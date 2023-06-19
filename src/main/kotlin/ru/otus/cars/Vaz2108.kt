package ru.otus.cars

import ru.otus.cars.fuelSystem.LpgMouth
import ru.otus.cars.fuelSystem.Tank
import ru.otus.cars.fuelSystem.TankMouth
import kotlin.math.roundToInt
import kotlin.math.tan
import kotlin.random.Random

/**
 * Восьмерка
 */
class Vaz2108 private constructor(_tank: Tank) : Car {

    private val tank: Tank
    init {
        tank = _tank
    }

    override val tankMouth = LpgMouth(tank)
    /**
     * Сам-себе-сборщик ВАЗ 2108.
     */
    companion object : CarBuilder {
        override fun build(plates: Car.Plates): Vaz2108 =
            Vaz2108(
                Tank(
                    _volume = 39,
                    _model = MODEL,
                    _currentVolume = (Random.nextDouble(1.0)*100.0).roundToInt()/100.0
                )
            ).apply {
            this.plates = plates
        }

        /**
         * Сход-развал
         */
        fun alignWheels(vaz2108: Vaz2108) {
            println("${MODEL}: Положение руля до: ${vaz2108.wheelAngle}")
            vaz2108.wheelAngle = Random.nextInt(-180, 180)
            println("${MODEL}: Положение руля после: ${vaz2108.wheelAngle}")
        }

        /**
         * Используем вместо STATIC
         */
        val MODEL = CarModel.Vaz2108
    }

    /**
     * Восьмерка едет так
     */
    fun zhzhzhzh() {
        println("Помчали на ${MODEL}:")
        println("Ж-ж-ж-ж....")
    }

    private var wheelAngle: Int = 0 // Положение руля
    private var currentSpeed: Int = 0 // Скока жмёт

    /**
     * Доступно сборщику
     * @see [build]
     */
    override lateinit var plates: Car.Plates
        private set

    // Выводим состояние машины
    override fun toString(): String {
        return "Vaz2108(plates=$plates)"
    }

    /**
     * Делегируем приборы внутреннему классу
     */
     val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2108!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2108.currentSpeed
        }

        override fun getLevelFuel(): Double {
            return tank.getContent()
        }
    }
}