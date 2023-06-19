package ru.otus.cars.fuelSystem

import ru.otus.cars.CarModel
import kotlin.math.round
import kotlin.math.roundToInt

/**
 * Топливный бак
 * volume - объем бака
 * model - модель машины
 * _currentVolume - текущий объем бака в о.е.
 */
class Tank( _volume: Int, _model: CarModel , _currentVolume: Double ) {

    private val volume: Int

    private val model: CarModel
    /**
     * текущий объем топлива (по умолчанию: полный бак)
     */
    private var currentVolume = 0.0

    init {
        volume = _volume
        model = _model
        if (_currentVolume<= 1){
            currentVolume = _currentVolume
        }else throw Exception("Значение от 0 до 1")

    }

    /**
     * возвращает объем топлива на запрашиваемый момент времени
     */
    fun getContent(): Double{
        return (currentVolume*100.0).roundToInt()/100.0
    }

    /**
     * поплнение тобъема топливного бака
     */
    fun receiveFuel(liters: Int){
        when(model){
            CarModel.Vaz2107, CarModel.Vaz2108 ->{
                currentVolume = (currentVolume * volume + liters)/volume
                if(currentVolume > 1.0) {
                    /**
                     * не можем иметь топлива в баке больше объема.
                     * Выбрасываем исключение если залили больше положенного
                     */
                    currentVolume = 1.0
                    throw Exception("Все вокруг залило топливом")

                }
            }
            CarModel.Taz -> {
                /**
                 * исключение для тазика , по заданию
                 */
                throw Exception("БаБах!!!!!!!! Таз взорвался!!!!!")
            }
        }
    }

}