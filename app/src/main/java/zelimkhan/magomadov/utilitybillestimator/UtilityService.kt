package zelimkhan.magomadov.utilitybillestimator

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun UtilityService(
    name: String,
    @DrawableRes icon: Int,
    previousValue: String = "",
    previousValueChange: (String) -> Unit,
    currentValue: String = "",
    currentValueChange: (String) -> Unit,
    tariff: String = "",
    tariffChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        CircleImage(icon = icon, size = 100.dp)
        Spacer(modifier = Modifier.height(32.dp))
        UtilityServiceTextField(
            "Предыдущие показания",
            value = previousValue,
            onValueChange = previousValueChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        UtilityServiceTextField(
            "Текущие показания",
            value = currentValue,
            currentValueChange
        )
        Spacer(modifier = Modifier.height(16.dp))
        UtilityServiceTextField("Тариф", value = tariff, tariffChange)
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
            UtilityService(
                name = "Свет",
                icon = R.drawable.light,
                modifier = Modifier.padding(32.dp),
                previousValue = "",
                previousValueChange = {},
                currentValue = "",
                currentValueChange = {},
                tariff = "",
                tariffChange = {},
            )
        }
    }
}