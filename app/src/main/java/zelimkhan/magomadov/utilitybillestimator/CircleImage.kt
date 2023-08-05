package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun CircleImage(icon: Int, size: Dp) {
    Image(
        painter = painterResource(id = icon),
        contentDescription = null,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
    )
}