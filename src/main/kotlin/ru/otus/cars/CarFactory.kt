package ru.otus.cars

/**
 * Автозавод
 */
interface CarFactory {
    /**
     * Выпусти машину
     */
    fun buildCar(plates: Car.Plates): Car
}

/**
 * Автозавод в Тольятти (он у нас один такой)
 */
object Togliatti : CarFactory {
    /**
     * Выпусти машину
     */
    override fun buildCar(plates: Car.Plates): Car {
        return buildVaz2107(plates)
    }

    /**
     * Выпусти машину нужной модели
     */
    fun buildCar(builder: CarBuilder, plates: Car.Plates): Car {
        return when(builder) {
            Vaz2107 -> buildVaz2107(plates)
            Vaz2108 -> buildVaz2108(plates)
        }
    }

    private fun buildVaz2107(plates: Car.Plates): Car {
        val vaz = Vaz2107.build(plates)
        println(vaz)
        return vaz
    }

    private fun buildVaz2108(plates: Car.Plates): Car {
        val vaz = Vaz2108.build(plates)
        return vaz
    }
}