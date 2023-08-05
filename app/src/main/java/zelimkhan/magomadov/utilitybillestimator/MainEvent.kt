package zelimkhan.magomadov.utilitybillestimator

sealed class MainEvent {
    class PreviousLightCounterChange(value: Int) : MainEvent()
    class CurrentLightCounterChange(value: Int) : MainEvent()
    class CurrentGasCounterChange(value: Int) : MainEvent()
    class PreviousGasCounterChange(value: Int) : MainEvent()
    class PreviousWaterCounterChange(value: Int) : MainEvent()
    class CurrentWaterCounterChange(value: Int) : MainEvent()
    class LightTariffChange(value: Double) : MainEvent()
    class GasTariffChange(value: Double) : MainEvent()
    class WaterTariffChange(value: Double) : MainEvent()
    object Calculate : MainEvent()
}