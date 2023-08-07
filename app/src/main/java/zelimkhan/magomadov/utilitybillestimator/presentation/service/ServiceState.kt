package zelimkhan.magomadov.utilitybillestimator.presentation.service

data class ServiceState(
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