package zelimkhan.magomadov.utilitybillestimator

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.math.BigDecimal

class MainViewModel : ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    private val _paymentState = MutableStateFlow(PaymentState())
    val paymentState = _paymentState.asStateFlow()

    fun onIntent(intent: MainIntent) {
        when (intent) {
            is MainIntent.PreviousLightCounterChange -> TODO()
            is MainIntent.CurrentLightCounterChange -> TODO()
            is MainIntent.LightTariffChange -> TODO()
            is MainIntent.CurrentGasCounterChange -> TODO()
            is MainIntent.CurrentWaterCounterChange -> TODO()
            is MainIntent.GasTariffChange -> TODO()
            is MainIntent.PreviousGasCounterChange -> TODO()
            is MainIntent.PreviousWaterCounterChange -> TODO()
            is MainIntent.WaterTariffChange -> TODO()
            MainIntent.Calculate -> calculatePayments()
        }
    }

    private fun calculatePayments() {
        val state = mainState.value
        val lightPayment = calculatePaymentsForService(
            state.previousLightCounter,
            state.currentLightCounter,
            state.lightTariff,
        )
        val gasPayment = calculatePaymentsForService(
            state.previousGasCounter,
            state.currentGasCounter,
            state.gasTariff,
        )
        val waterPayment = calculatePaymentsForService(
            state.previousWaterCounter,
            state.currentWaterCounter,
            state.waterTariff,
        )
        val totalPayment = calculateTotalPayment(
            light = lightPayment,
            gas = gasPayment,
            water = waterPayment
        )

        _paymentState.update {
            PaymentState(
                lightPayment = lightPayment,
                gasPayment = gasPayment,
                waterPayment = waterPayment,
                totalPayment = totalPayment
            )
        }
    }

    private fun calculatePaymentsForService(
        previousCounter: String,
        currentCounter: String,
        tariff: String,
    ): String {
        val previousValue = BigDecimal(previousCounter)
        val currentValue = BigDecimal(currentCounter)
        val tariffValue = BigDecimal(tariff)

        val consumption = currentValue.subtract(previousValue)
        val payment = consumption.multiply(tariffValue)

        return payment.toString()
    }

    private fun calculateTotalPayment(
        light: String,
        gas: String,
        water: String,
    ): String {
        val lightBigDecimal = light.toBigDecimal()
        val gasBigDecimal = gas.toBigDecimal()
        val waterBigDecimal = water.toBigDecimal()

        return (lightBigDecimal + gasBigDecimal + waterBigDecimal).toString()
    }
}