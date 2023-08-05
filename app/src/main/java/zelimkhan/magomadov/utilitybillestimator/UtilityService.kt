package zelimkhan.magomadov.utilitybillestimator

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UtilityService(
    title: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        CircleImage(icon, 100.dp)
        Spacer(modifier = Modifier.height(32.dp))
        UtilityServiceTextField("Предыдущие показания")
        Spacer(modifier = Modifier.height(16.dp))
        UtilityServiceTextField("Текущие показания")
        Spacer(modifier = Modifier.height(16.dp))
        UtilityServiceTextField("Тариф")
    }
}