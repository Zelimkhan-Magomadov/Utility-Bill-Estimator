package zelimkhan.magomadov.utilitybillestimator

data class MainState(
    val previousLightCounter: String = "0",
    val currentLightCounter: String = "0",
    val previousGasCounter: String = "0",
    val currentGasCounter: String = "0",
    val previousWaterCounter: String = "0",
    val currentWaterCounter: String = "0",
    val lightTariff: String = "0",
    val gasTariff: String = "0",
    val waterTariff: String = "0",
)

data class PaymentState(
    val lightPayment: String = "0",
    val gasPayment: String = "0",
    val waterPayment: String = "0",
    val totalPayment: String = "0",
)