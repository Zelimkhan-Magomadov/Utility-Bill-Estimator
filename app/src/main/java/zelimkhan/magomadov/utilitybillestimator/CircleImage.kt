package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import zelimkhan.magomadov.utilitybillestimator.ui.theme.UtilityBillEstimatorTheme

@Composable
fun CircleImage(
    icon: Int,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = modifier
            .size(size)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UtilityBillEstimatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(contentAlignment = Alignment.TopCenter) {
                CircleImage(
                    icon = R.drawable.light,
                    size = 100.dp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}