package DaggerDI

import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Scope

@SingleInstance
class Car  @Inject constructor( val tire:Tire,val dashBoard:DashBoard){
    @Inject
    @MainEngine
    lateinit var engine:Engine //For kotlin when injecting using field injection
     //set the field to have lateinit if not it will compile to private null as in Kotlin fields are complied into private Java fields with public setters and getters
     //We are going to use field injection to inject a field of type Engine into the Car class

    @Inject
    @SpareEngine
    lateinit var spareEngine:Engine
    //Some time we want to pass different instances of a type depending on the situation or field
    //For example in the class Car we have two engines one is the main and one is the spare
    //We dont want the spare engine to have the same number of valves as the main
    //so we use @Qualifiers we create or custom own  qualifier annotations
    //and apply them to the main and spare engine
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

//There are some times we want to share one instance of a type or dependency through out the dependency graph
//To do that we use Scope annotations
//Scope annotations define the how instances of a type are created as the share the same lifetime as a component
//For example if we annotate
//The component with @Singleton and the Car class with @Singleton
//Then for each component instance then only one car is instance is created and used no matter how many times we call the get Car function
//The singleton name  doesnt matter as any scope annotation with any name can do that
//For that we will create a new scope annotation and put on both Car class and CarComponent

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleInstance{}


//This is for the main engine
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainEngine
//This is for the spare engine

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class SpareEngine


//We can also state @BindOptionalOf
//This tells Dagger that if a Binding of this type is available or it knows how to create this type it should
//If not return null
//This is should be all for now
//We also have Dagger for Aynchronous Operation and Assisted DI which is in the documentation
//We will then use Dagger on Android
