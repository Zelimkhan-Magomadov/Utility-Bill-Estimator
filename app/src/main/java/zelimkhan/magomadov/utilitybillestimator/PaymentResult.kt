package zelimkhan.magomadov.utilitybillestimator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun PaymentResult(
    paymentState: PaymentState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Выплаты",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                Payment(serviceName = "Свет:", payment = paymentState.lightPayment)
                Spacer(modifier = Modifier.height(8.dp))
                Payment(serviceName = "Газ:", paymentState.gasPayment)
                Spacer(modifier = Modifier.height(8.dp))
                Payment(serviceName = "Вода:", paymentState.waterPayment)
                Spacer(modifier = Modifier.height(16.dp))
                Payment(serviceName = "Всего к оплате:", paymentState.totalPayment)
            }
        }
    }
}

@Composable
private fun Payment(
    serviceName: String,
    payment: String
) {
    Row {
        Text(text = serviceName)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = payment,
            textAlign = TextAlign.End,
            modifier = Modifier.fillMaxWidth()
        )
    }
}