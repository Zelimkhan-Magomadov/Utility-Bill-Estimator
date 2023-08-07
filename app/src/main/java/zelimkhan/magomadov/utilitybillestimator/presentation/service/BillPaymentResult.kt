package zelimkhan.magomadov.utilitybillestimator.presentation.service

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BillPaymentResult(
    paymentState: BillPaymentState,
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
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray)
        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                PaymentRow(serviceName = "Свет:", payment = paymentState.lightPayment)
                Spacer(modifier = Modifier.height(2.dp))
                PaymentRow(serviceName = "Газ:", paymentState.gasPayment)
                Spacer(modifier = Modifier.height(2.dp))
                PaymentRow(serviceName = "Вода:", paymentState.waterPayment)
                Spacer(modifier = Modifier.height(16.dp))
                PaymentRow(serviceName = "Всего к оплате:", paymentState.totalPayment)
            }
        }
    }
}

@Composable
private fun PaymentRow(
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