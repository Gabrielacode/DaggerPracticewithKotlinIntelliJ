package DaggerDI

import javax.inject.Inject

class Car  @Inject constructor(){
    val tires = 4
    init{
        println("Car has been created")
    }
}