package ru.otus.cars.fuelSystem

import ru.otus.cars.gasStation.FuelType

/**
 * Универсальная горловина
 * при инициализации прикрепляем топливный бак и скрываем реализацию для пользователей
 * реализована общая часть методов TankMouth
 * Использем для таза, ему без разницы все равно в конце взорвется =)
 */
open class Mouth(protected val tank: Tank) : TankMouth {

    /**
     * Состояние крышки бака (пока не понял зачем придумал =) )
     * По дефолту - закрыта
     */
    override var cap: CapTankMouth = CapTankMouth.CLOSE

    /**
     * Открытие и заправка бака топливом
     */
    override fun open(fuelType: FuelType, countOil: Int) {
        if(cap == CapTankMouth.CLOSE) {
            cap = CapTankMouth.OPEN
            println("бак открыт")
            tank.receiveFuel(countOil)
            println("Заправка...")
        }else{
            println("бак уже открыт")
        }
    }

    /**
     * Закрытие бака
     */
    override fun close() {
        if (cap == CapTankMouth.OPEN) {
            cap = CapTankMouth.CLOSE
            println("бак закрыт")
        } else {
            println("бак уже закрыт")
        }
    }
}