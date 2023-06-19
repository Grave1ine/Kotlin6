package ru.otus.cars.gasStation

import ru.otus.cars.Car
import ru.otus.cars.fuelSystem.LpgMouth
import ru.otus.cars.fuelSystem.Mouth
import ru.otus.cars.fuelSystem.PetrolMouth
import kotlin.random.Random

object Station {

    fun refueling(car: Car, countOil: Int){
        try {
            when (car.tankMouth) {
                is PetrolMouth -> {
                    car.tankMouth.open(FuelType.PETROL, countOil)
                    car.tankMouth.close()
                }
                is LpgMouth -> {
                    car.tankMouth.open(FuelType.Lpg, countOil)
                    car.tankMouth.close()
                }
                is Mouth -> {
                    val rnd  = Random.nextInt(2)
                    when(rnd){
                        0 -> {
                            car.tankMouth.open(FuelType.Lpg, countOil)
                            car.tankMouth.close()
                        }
                        else ->{
                            car.tankMouth.open(FuelType.PETROL, countOil)
                            car.tankMouth.close()
                        }
                    }
                }
            }
        } catch (e: Exception){
            println(e.message)
        }
    }

}