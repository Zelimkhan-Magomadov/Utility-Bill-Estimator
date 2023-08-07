package zelimkhan.magomadov.utilitybillestimator.presentation.service

sealed class ServiceIntent {
    class PreviousLightCounterChange(val value: String) : ServiceIntent()
    class CurrentLightCounterChange(val value: String) : ServiceIntent()
    class CurrentGasCounterChange(val value: String) : ServiceIntent()
    class PreviousGasCounterChange(val value: String) : ServiceIntent()
    class PreviousWaterCounterChange(val value: String) : ServiceIntent()
    class CurrentWaterCounterChange(val value: String) : ServiceIntent()
    class LightTariffChange(val value: String) : ServiceIntent()
    class GasTariffChange(val value: String) : ServiceIntent()
    class WaterTariffChange(val value: String) : ServiceIntent()
    object Calculate : ServiceIntent()
}