package zelimkhan.magomadov.utilitybillestimator

sealed class MainIntent {
    class PreviousLightCounterChange(val value: String) : MainIntent()
    class CurrentLightCounterChange(val value: String) : MainIntent()
    class CurrentGasCounterChange(val value: String) : MainIntent()
    class PreviousGasCounterChange(val value: String) : MainIntent()
    class PreviousWaterCounterChange(val value: String) : MainIntent()
    class CurrentWaterCounterChange(val value: String) : MainIntent()
    class LightTariffChange(val value: String) : MainIntent()
    class GasTariffChange(val value: String) : MainIntent()
    class WaterTariffChange(val value: String) : MainIntent()
    object Calculate : MainIntent()
}