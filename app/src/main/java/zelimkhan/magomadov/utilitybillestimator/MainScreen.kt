package zelimkhan.magomadov.utilitybillestimator

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
import zelimkhan.magomadov.utilitybillestimator.ui.theme.UtilityBillEstimatorTheme


@Composable
fun MainScreen(
    mainState: MainState,
    paymentState: PaymentState,
    onIntent: (MainIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        UtilityService(
            name = "Свет",
            icon = R.drawable.light,
            previousValue = mainState.previousLightCounter,
            previousValueChange = { onIntent(MainIntent.PreviousLightCounterChange(it)) },
            currentValue = mainState.currentLightCounter,
            currentValueChange = { onIntent(MainIntent.CurrentLightCounterChange(it)) },
            tariff = mainState.lightTariff,
            tariffChange = { onIntent(MainIntent.LightTariffChange(it)) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        UtilityService(
            name = "Газ",
            icon = R.drawable.gas,
            previousValue = mainState.previousGasCounter,
            previousValueChange = { onIntent(MainIntent.PreviousGasCounterChange(it)) },
            currentValue = mainState.currentGasCounter,
            currentValueChange = { onIntent(MainIntent.CurrentGasCounterChange(it)) },
            tariff = mainState.gasTariff,
            tariffChange = { onIntent(MainIntent.GasTariffChange(it)) },
        )

        Spacer(modifier = Modifier.height(32.dp))

        UtilityService(
            name = "Вода",
            icon = R.drawable.water,
            previousValue = mainState.previousWaterCounter,
            previousValueChange = { onIntent(MainIntent.PreviousWaterCounterChange(it)) },
            currentValue = mainState.currentWaterCounter,
            currentValueChange = { onIntent(MainIntent.CurrentWaterCounterChange(it)) },
            tariff = mainState.waterTariff,
            tariffChange = { onIntent(MainIntent.WaterTariffChange(it)) },
            isLastService = true
        )

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = { onIntent(MainIntent.Calculate) },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text(text = "Вычислить")
        }

        Spacer(modifier = Modifier.height(32.dp))

        PaymentResult(paymentState = paymentState)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    UtilityBillEstimatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(
                mainState = MainState(),
                onIntent = {},
                paymentState = PaymentState(),
            )
        }
    }
}