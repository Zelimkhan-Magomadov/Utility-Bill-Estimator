package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zelimkhan.magomadov.utilitybillestimator.ui.theme.UtilityBillEstimatorTheme


@Composable
fun MainScreen(
    //mainState: MainState,
    //paymentState: PaymentState,
    //onEvent: (MainEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        UtilityService(title = "Свет", icon = R.drawable.light)
        Spacer(modifier = Modifier.height(32.dp))
        UtilityService(title = "Газ", icon = R.drawable.light)
        Spacer(modifier = Modifier.height(32.dp))
        UtilityService(title = "Вода", icon = R.drawable.light)
        Spacer(modifier = Modifier.height(64.dp))
        CalculateButton(onCalculate = { })
        Spacer(modifier = Modifier.height(32.dp))
        PaymentResult(PaymentState())
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun CalculateButton(
    onCalculate: () -> Unit
) {
    Button(onClick = onCalculate) {
        Text(text = "Вычислить")
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
                //mainState = MainState(),
                //paymentState = PaymentState(),
                //onEvent = {}
            )
        }
    }
}