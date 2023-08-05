package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UtilityServiceTextField(
    placeholder: String,
) {
    OutlinedTextField(
        value = "",
        onValueChange = { },
        shape = RoundedCornerShape(8.dp),
        placeholder = { Text(text = placeholder) },
        modifier = Modifier.fillMaxWidth()
    )
}