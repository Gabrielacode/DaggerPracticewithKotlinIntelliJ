import DaggerDI.CarComponent
import DaggerDI.DaggerCarComponent

fun main(args: Array<String>) {
   val carComponent:CarComponent = DaggerCarComponent.create()
   val car =  carComponent.getCar()
}
//PLS NOTE WHEN WORK WITH INTELLI J YOU MIGHT RUN INTO SOME ISSUES
/*
* FOR ANNOTATION PROCCESSING USE Kotlin Kapt plugin*/
//Then in th Build .gradle use the kapt extension function and set correctErrorTypes to tru
//Pls set your JVm to 8 and above in the jvm