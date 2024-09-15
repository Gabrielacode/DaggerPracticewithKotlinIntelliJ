import DaggerDI.CarComponent
import DaggerDI.DaggerCarComponent
import DaggerDI.Engine

fun main(args: Array<String>) {
   val carComponent:CarComponent = DaggerCarComponent.create()
   val car =  carComponent.getCar()
   //Here we will check whether the engine of the car was injected into it by field injection
   println(car.engine is Engine)
}
//PLS NOTE WHEN WORK WITH INTELLI J YOU MIGHT RUN INTO SOME ISSUES
/*
* FOR ANNOTATION PROCCESSING USE Kotlin Kapt plugin*/
//Then in th Build .gradle use the kapt extension function and set correctErrorTypes to tru
//Pls set your JVm to 8 and above in the jvm