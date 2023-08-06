package zelimkhan.magomadov.utilitybillestimator

sealed class MainIntent {
    class PreviousLightCounterChange(value: String) : MainIntent()
    class CurrentLightCounterChange(value: String) : MainIntent()
    class CurrentGasCounterChange(value: String) : MainIntent()
    class PreviousGasCounterChange(value: String) : MainIntent()
    class PreviousWaterCounterChange(value: String) : MainIntent()
    class CurrentWaterCounterChange(value: String) : MainIntent()
    class LightTariffChange(value: String) : MainIntent()
    class GasTariffChange(value: String) : MainIntent()
    class WaterTariffChange(value: String) : MainIntent()
    object Calculate : MainIntent()
}