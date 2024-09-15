package DaggerDI

import javax.inject.Inject

class Car  @Inject constructor( val tire:Tire,val dashBoard:DashBoard){
    @Inject
    lateinit var engine:Engine //For kotlin when injecting using field injection
     //set the field to have lateinit if not it will compile to private null as in Kotlin fields are complied into private Java fields with public setters and getters
    val tires = 4

    //We are going to use field injection to inject a field of type Engine into the Car class

    init{
        println("Car has been created")
    }
}

