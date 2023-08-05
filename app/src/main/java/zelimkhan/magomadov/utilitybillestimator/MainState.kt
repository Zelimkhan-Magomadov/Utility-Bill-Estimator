package zelimkhan.magomadov.utilitybillestimator

data class MainState(
    val previousLightCounter: Int = 0,
    val currentLightCounter: Int = 0,
    val previousGasCounter: Int = 0,
    val currentGasCounter: Int = 0,
    val previousWaterCounter: Int = 0,
    val currentWaterCounter: Int = 0,
    val lightTariff: Double = .0,
    val gasTariff: Double = .0,
    val waterTariff: Double = .0,
)

data class PaymentState(
    val lightPayment: String = "0",
    val gasPayment: String = "0",
    val waterPayment: String = "0",
    val totalPayment: String = "0",
)