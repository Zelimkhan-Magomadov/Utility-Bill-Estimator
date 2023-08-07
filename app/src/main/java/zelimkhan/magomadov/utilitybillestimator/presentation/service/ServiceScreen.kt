package zelimkhan.magomadov.utilitybillestimator.presentation.service

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zelimkhan.magomadov.utilitybillestimator.R
import zelimkhan.magomadov.utilitybillestimator.presentation.ui.theme.UtilityBillEstimatorTheme


@Composable
fun ServiceScreen(
    mainState: ServiceState,
    paymentState: BillPaymentState,
    onIntent: (ServiceIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        ServiceInputSection(
            name = "Свет",
            icon = R.drawable.ic_light,
            previousValue = mainState.previousLightCounter,
            previousValueChange = { onIntent(ServiceIntent.PreviousLightCounterChange(it)) },
            currentValue = mainState.currentLightCounter,
            currentValueChange = { onIntent(ServiceIntent.CurrentLightCounterChange(it)) },
            tariff = mainState.lightTariff,
            tariffChange = { onIntent(ServiceIntent.LightTariffChange(it)) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        ServiceInputSection(
            name = "Газ",
            icon = R.drawable.ic_gas,
            previousValue = mainState.previousGasCounter,
            previousValueChange = { onIntent(ServiceIntent.PreviousGasCounterChange(it)) },
            currentValue = mainState.currentGasCounter,
            currentValueChange = { onIntent(ServiceIntent.CurrentGasCounterChange(it)) },
            tariff = mainState.gasTariff,
            tariffChange = { onIntent(ServiceIntent.GasTariffChange(it)) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        ServiceInputSection(
            name = "Вода",
            icon = R.drawable.ic_water,
            previousValue = mainState.previousWaterCounter,
            previousValueChange = { onIntent(ServiceIntent.PreviousWaterCounterChange(it)) },
            currentValue = mainState.currentWaterCounter,
            currentValueChange = { onIntent(ServiceIntent.CurrentWaterCounterChange(it)) },
            tariff = mainState.waterTariff,
            tariffChange = { onIntent(ServiceIntent.WaterTariffChange(it)) },
            isLastService = true
        )

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = { onIntent(ServiceIntent.Calculate) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Вычислить")
        }

        Spacer(modifier = Modifier.height(32.dp))

        BillPaymentResult(paymentState = paymentState)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UtilityBillEstimatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ServiceScreen(
                mainState = ServiceState(),
                onIntent = {},
                paymentState = BillPaymentState(),
            )
        }
    }
}