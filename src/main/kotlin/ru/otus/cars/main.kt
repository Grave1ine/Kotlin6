package ru.otus.cars

import ru.otus.cars.gasStation.Station
import kotlin.random.Random

fun main() {
    /*
    генерим список случайных тачек
     */
    val listCar = emptyList<Car>().toMutableList()
    for(i in 0..10){
        listCar.add(modelMake())
        println(listCar[i].toString())
    }
    /*
     добавляем в конце тазик
     */
    listCar.add(Taz)
    println(listCar[listCar.size -1].toString())

    for (car in listCar){
        var vazOutput = when(car){
            is Vaz2107 -> {
                car.VazOutput()
            }
            is Vaz2108 -> {
                car.VazOutput()
            }
            is Taz ->{
                car.VazOutput
            }
        }
        if(vazOutput.getLevelFuel() == 1.0){
            println("у вас полный бак")
            continue
        }
        println("Уровень топлива в машине ${car.toString()}: ${vazOutput.getLevelFuel()}")

        Station.refueling(car, countFuel(vazOutput.getLevelFuel()))

        println("Уровень топлива в машине после заправки: ${vazOutput.getLevelFuel()}")
    }
    println("конец")
}

fun countFuel(levelFuel: Double): Int{
    var rnd = Random.nextInt(3)
    return when(rnd){
        0 -> (39 - 39 * levelFuel).toInt() //до полного
        1 -> (39 - 39 * levelFuel).toInt() - 1//не весь
        else -> (39 - 39 * levelFuel).toInt() +1 //больше бака
    }
}


fun modelMake(): Car {
    val rnd = Random.nextInt(10)
    return when{
        rnd >=5 -> Togliatti.buildCar(Vaz2107, randomPlates())
        else -> Togliatti.buildCar(Vaz2108, randomPlates())
    }
}

fun randomPlates(): Car.Plates{
    return Car.Plates((100..999).random().toString(),(10..99).random())
}