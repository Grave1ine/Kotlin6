package ru.otus.cars

import ru.otus.cars.fuelSystem.PetrolMouth
import ru.otus.cars.fuelSystem.TankMouth

/**
 * Машина целиком
 */
sealed interface Car : CarInput{
    /**
     * Номерной знак
     */
    val plates: Plates

    /**
     * Внутренний статический класс - номерой знак
     */
    data class Plates(val number: String, val region: Int)

    /**
     * Топливная система, через которую будут заправлять топливный бак
     */
    val tankMouth: TankMouth
}