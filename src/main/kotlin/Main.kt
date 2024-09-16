import DaggerDI.CarComponent
import DaggerDI.DaggerCarComponent
import DaggerDI.Engine
import DaggerDI.RoundTire

fun main(args: Array<String>) {
   val carComponent:CarComponent = DaggerCarComponent.builder().buildCarComponentwithCustomEngine(Engine()).buildCarComponent()
   val car =  carComponent.getCar()
   //Here we will check whether the engine of the car was injected into it by field injection
   println(car.engine is Engine)
    println(car.dashBoard)
    println("Tire is a Round Tire ${car.tire is RoundTire}")

    println(car.listofLicences)
    println(car.mapofKeystoPouchNumber)

    //Set scope of car in Car Component
    val car1  = carComponent.getCar()
    val car2 = carComponent.getCar()
    println(car1 == car2)
    println(car1)
    val mechanicRoom = carComponent.getMechanicRoom().build()
    println(car1.engine.valves == mechanicRoom.getEngine().valves)
    //As we see the subcomponent  get values from the main component

    val carComponentwithCustomEngine = DaggerCarComponent.builder().buildCarComponentwithCustomEngine(Engine().apply { valves = 145 }).buildCarComponent()
    val carwithCustomEng = carComponentwithCustomEngine.getCar()
    println(carwithCustomEng.engine.valves)

}
//PLS NOTE WHEN WORK WITH INTELLI J YOU MIGHT RUN INTO SOME ISSUES
/*
* FOR ANNOTATION PROCCESSING USE Kotlin Kapt plugin*/
//Then in th Build .gradle use the kapt extension function and set correctErrorTypes to tru
//Pls set your JVm to 8 and above in the jvm