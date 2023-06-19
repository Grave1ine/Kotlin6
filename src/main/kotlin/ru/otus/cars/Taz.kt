package ru.otus.cars

import ru.otus.cars.fuelSystem.Mouth
import ru.otus.cars.fuelSystem.Tank
import ru.otus.cars.fuelSystem.TankMouth
import kotlin.math.roundToInt
import kotlin.random.Random

/**
 * Тачка не едет
 */
object Taz : Car {

    private val tank = Tank(
        _volume = 39,
        _model = CarModel.Taz,
        _currentVolume = (Random.nextDouble(1.0) * 100.0).roundToInt() / 100.0
    )

    /**
     * Номерной знак
     */
    override val plates: Car.Plates
        get() = throw IllegalStateException("Тачка без номеров")

    override val tankMouth: TankMouth = Mouth(tank)

    /**
     * Следит за машиной
     */
/*
     val carOutput: CarOutput
        get() = throw IllegalStateException("Приборы сняты")
*/
    val VazOutput = object : CarOutput{
        override fun getCurrentSpeed(): Int {
            return -1
        }

        override fun getLevelFuel(): Double {
            return tank.getContent()
        }

    }

    /**
     * Руль вправо на [degrees] градусов
     */
    override fun wheelToRight(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    /**
     * Руль влево на [degrees] градусов
     */
    override fun wheelToLeft(degrees: Int) {
        throw IllegalStateException("Руля нет")
    }

    override fun toString(): String {
        return "Taz"
    }
}