package zelimkhan.magomadov.utilitybillestimator.presentation.service

data class BillPaymentState(
    val lightPayment: String = "0",
    val gasPayment: String = "0",
    val waterPayment: String = "0",
    val totalPayment: String = "0",
)