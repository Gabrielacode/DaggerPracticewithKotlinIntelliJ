package DaggerDI

import javax.inject.Inject

class Car  @Inject constructor(){
    @Inject
     lateinit var engine:Engine //For kotlin when injecting using field injection
     //set the field to have lateinit if not it will compile to private null
    val tires = 4
    //We are going to use field injection to inject a field of type Engine into the Car class

    init{
        println("Car has been created")
    }
}

