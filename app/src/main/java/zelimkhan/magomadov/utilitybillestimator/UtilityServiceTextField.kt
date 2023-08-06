package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zelimkhan.magomadov.utilitybillestimator.ui.theme.UtilityBillEstimatorTheme

@Composable
fun UtilityServiceTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        shape = RoundedCornerShape(8.dp),
        placeholder = { Text(text = placeholder) },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UtilityBillEstimatorTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            var value by remember { mutableStateOf("") }
            val onValueChange: (String) -> Unit = { s -> value = s }
            UtilityServiceTextField(
                placeholder = "Показания",
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}