package ru.otus.cars.fuelSystem

import ru.otus.cars.gasStation.FuelType

/**
 * горловина бензобака (бензин)
 */
class PetrolMouth(_tank: Tank) : Mouth(_tank) {
    /**
     *  Открываем бак и заливаем countOil бензина.
     *  Дополнительно проводится проверка соответствия топлива
     *  если залили не то топливо, то выбрасывается исключение
     */
    override fun open(fuelType: FuelType, countOil: Int){
        if (fuelType == FuelType.Lpg) throw Exception("Машине конец")
        super.open(fuelType, countOil)
    }

}