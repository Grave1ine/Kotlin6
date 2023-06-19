package ru.otus.cars.fuelSystem

import ru.otus.cars.gasStation.FuelType

/**
 * Топливная горловина
 */
sealed interface TankMouth{

    var cap: CapTankMouth

    fun open(fuelType: FuelType, countOil : Int)

    fun close()
}