package zelimkhan.magomadov.utilitybillestimator

data class MainState(
    val previousLightCounter: String = "",
    val currentLightCounter: String = "",
    val previousGasCounter: String = "",
    val currentGasCounter: String = "",
    val previousWaterCounter: String = "",
    val currentWaterCounter: String = "",
    val lightTariff: String = "",
    val gasTariff: String = "",
    val waterTariff: String = "",
)

data class PaymentState(
    val lightPayment: String = "0",
    val gasPayment: String = "0",
    val waterPayment: String = "0",
    val totalPayment: String = "0",
)