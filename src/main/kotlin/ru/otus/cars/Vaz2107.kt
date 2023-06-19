package ru.otus.cars

import ru.otus.cars.fuelSystem.PetrolMouth
import ru.otus.cars.fuelSystem.Tank
import ru.otus.cars.fuelSystem.TankMouth
import kotlin.math.roundToInt
import kotlin.random.Random


/**
 * Семёрочка
 * специалист должен поставить систему
 */
class Vaz2107 private constructor(_tank: Tank) : Car {

    private val tank: Tank
    init {
        tank = _tank
    }
    /**
     * Топливная горловина
     */
    override val tankMouth  = PetrolMouth(tank)


    /**
     * Сам-себе-сборщик ВАЗ 2107.
     */
    companion object : CarBuilder {
        val MODEL = CarModel.Vaz2107

        override fun build(plates: Car.Plates): Vaz2107 =
            Vaz2107(
                Tank(
                    _volume = 39,
                    _model = MODEL,
                    _currentVolume = (Random.nextDouble(1.0)*100.0).roundToInt()/100.0
                )
            ).apply {
            this.plates = plates
        }

        /**
         * Проверь, ездит или нет
         */
        fun test(vaz2107: Vaz2107) {
            println("${MODEL}: Проверка движка...")
            vaz2107.currentSpeed = Random.nextInt(0, 60)
            println("${MODEL}: Скорость: ${vaz2107.carOutput.getCurrentSpeed()}")
        }
    }

    /**
     * Семерка едет так
     */
    fun drdrdrdrdr() {
        println("Помчали на $MODEL:")
        println("Др-др-др-др....")
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
        return "Vaz2107(plates=$plates)"//, wheelAngle=$wheelAngle, currentSpeed=$currentSpeed)"
    }
    /**
     * Делегируем приборы внутреннему классу
     */
    val carOutput: CarOutput = VazOutput()

    override fun wheelToRight(degrees: Int) { wheelAngle += degrees }

    override fun wheelToLeft(degrees: Int) { wheelAngle -= degrees }

    /**
     * Имеет доступ к внутренним данным ЭТОГО ВАЗ-2107!
     */
    inner class VazOutput : CarOutput {
        override fun getCurrentSpeed(): Int {
            return this@Vaz2107.currentSpeed
        }
        override fun getLevelFuel(): Double {
            return tank.getContent()
        }
    }
}