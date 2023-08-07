package zelimkhan.magomadov.utilitybillestimator.presentation.service

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

class ServiceViewModel : ViewModel() {
    private val _serviceState = MutableStateFlow(ServiceState())
    val serviceState = _serviceState.asStateFlow()

    private val _billPaymentState = MutableStateFlow(BillPaymentState())
    val billPaymentState = _billPaymentState.asStateFlow()

    fun onIntent(intent: ServiceIntent) {
        when (intent) {
            is ServiceIntent.PreviousLightCounterChange ->
                _serviceState.update { it.copy(previousLightCounter = intent.value) }

            is ServiceIntent.CurrentLightCounterChange ->
                _serviceState.update { it.copy(currentLightCounter = intent.value) }

            is ServiceIntent.LightTariffChange ->
                _serviceState.update { it.copy(lightTariff = intent.value) }

            is ServiceIntent.PreviousGasCounterChange ->
                _serviceState.update { it.copy(previousGasCounter = intent.value) }

            is ServiceIntent.CurrentGasCounterChange ->
                _serviceState.update { it.copy(currentGasCounter = intent.value) }

            is ServiceIntent.GasTariffChange ->
                _serviceState.update { it.copy(gasTariff = intent.value) }

            is ServiceIntent.PreviousWaterCounterChange ->
                _serviceState.update { it.copy(previousWaterCounter = intent.value) }

            is ServiceIntent.CurrentWaterCounterChange ->
                _serviceState.update { it.copy(currentWaterCounter = intent.value) }

            is ServiceIntent.WaterTariffChange ->
                _serviceState.update { it.copy(waterTariff = intent.value) }

            ServiceIntent.Calculate -> calculateBillPayments()
        }
    }

    private fun calculateBillPayments() {
        val state = serviceState.value
        val lightPayment = calculatePaymentForService(
            state.previousLightCounter,
            state.currentLightCounter,
            state.lightTariff,
        )
        val gasPayment = calculatePaymentForService(
            state.previousGasCounter,
            state.currentGasCounter,
            state.gasTariff,
        )
        val waterPayment = calculatePaymentForService(
            state.previousWaterCounter,
            state.currentWaterCounter,
            state.waterTariff,
        )
        val totalPayment = calculateTotalBillPayment(
            light = lightPayment,
            gas = gasPayment,
            water = waterPayment
        )

        _billPaymentState.update {
            BillPaymentState(
                lightPayment = formatPaymentNumber(lightPayment),
                gasPayment = formatPaymentNumber(gasPayment),
                waterPayment = formatPaymentNumber(waterPayment),
                totalPayment = formatPaymentNumber(totalPayment)
            )
        }
    }

    private fun calculatePaymentForService(
        previousCounter: String,
        currentCounter: String,
        tariff: String,
    ): String {
        // Todo: Replace with normal error handling
        if (previousCounter.isEmpty() || currentCounter.isEmpty() || tariff.isEmpty())
            return "0"

        val previousValue = previousCounter.toBigDecimal()
        val currentValue = currentCounter.toBigDecimal()
        val tariffValue = tariff.toBigDecimal()

        val consumption = currentValue.subtract(previousValue)
        val payment = consumption.multiply(tariffValue)

        return payment.toString()
    }

    private fun calculateTotalBillPayment(
        light: String,
        gas: String,
        water: String,
    ): String {
        val lightBigDecimal = light.toBigDecimal()
        val gasBigDecimal = gas.toBigDecimal()
        val waterBigDecimal = water.toBigDecimal()

        return (lightBigDecimal + gasBigDecimal + waterBigDecimal).toString()
    }

    private fun formatPaymentNumber(number: String): String {
        val numberFormat = NumberFormat.getInstance()
        return numberFormat.format(number.toBigDecimal())
    }
}