package DaggerDI

import javax.inject.Inject

class Car  @Inject constructor( val tire:Tire,val dashBoard:DashBoard){
    @Inject
    lateinit var engine:Engine //For kotlin when injecting using field injection
     //set the field to have lateinit if not it will compile to private null as in Kotlin fields are complied into private Java fields with public setters and getters
     //We are going to use field injection to inject a field of type Engine into the Car class
    val tires = 4
    @Inject
    lateinit var listofLicences:Set< @JvmSuppressWildcards String>
    @Inject
    lateinit var mapofKeystoPouchNumber:Map<@JvmSuppressWildcards String,Int>
    //Dagger supports multibindings for collections such as Set and Maps
    //This allows modules to contribute elements to a collection and Dagger collects them all so when a dependency for that collection is needed
    //Dagger provides  a collection that contains all the elements contributed by the modules
// At the injection of the fields we should add the annotation  @JVM suppress wildcards as When compiling Kotlin to Java wild cards can be added to the type
    //So from <String> to <? extends String> which can cause an error



    init{
        println("Car has been created")
    }
}

