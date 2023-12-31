package zelimkhan.magomadov.utilitybillestimator.presentation.service

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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zelimkhan.magomadov.utilitybillestimator.R
import zelimkhan.magomadov.utilitybillestimator.presentation.component.CircleImage
import zelimkhan.magomadov.utilitybillestimator.presentation.ui.theme.UtilityBillEstimatorTheme

@Composable
fun ServiceInputSection(
    name: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    previousValue: String = "",
    previousValueChange: (String) -> Unit,
    currentValue: String = "",
    currentValueChange: (String) -> Unit,
    tariff: String = "",
    tariffChange: (String) -> Unit,
    isLastService: Boolean = false
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = name, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        CircleImage(icon = icon, size = 100.dp)
        Spacer(modifier = Modifier.height(32.dp))
        ServiceTextField(
            hint = "Предыдущие показания",
            value = previousValue,
            onValueChange = previousValueChange
        )
        Spacer(modifier = Modifier.height(8.dp))
        ServiceTextField(
            hint = "Текущие показания",
            value = currentValue,
            onValueChange = currentValueChange
        )
        Spacer(modifier = Modifier.height(8.dp))
        ServiceTextField(
            hint = "Тариф",
            value = tariff,
            onValueChange = tariffChange,
            imeAction = if (isLastService) ImeAction.Done else ImeAction.Next
        )
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
            ServiceInputSection(
                name = "Свет",
                icon = R.drawable.ic_light,
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