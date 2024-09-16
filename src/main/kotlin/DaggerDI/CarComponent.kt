package DaggerDI

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

@Component(modules = [TireAndDashBoardModule::class, OneLicenceAndPouch::class,ManyLicencesAndPouch::class])
@SingleInstance
interface CarComponent {
    fun getCar():Car


    @Component.Builder //This tells Dagger that it should provide an implementation of this interface that is a builder of Component
    interface CarComponentBuilder{
        //If our modules are classes we should also provide a method for our modules
        fun buildCarComponent():CarComponent
    }
    //If we have Component.Builder we should not have a Component.Factory as well
}
//We are going to create a module to provide bindings for the
// dependency we are going to inject
@Module
abstract class TireAndDashBoardModule(){
    @Binds
     abstract fun bindTire(tire:RoundTire):Tire //Bind the instance of Round Tire for any dependency of type Tire


     companion object{
         @Provides
         fun providesDashBoard():DashBoard{
             return DashBoard.Builder().setColor(4).steeringSize(12).build()
         }
     }

    //Can be null but the injection sites must also specify that they can also be nullable
    //this type of dashboard will be used for all instances of DashBoard
}
//By default, Components do have builder and /or factory where we can create the component and Dagger can also create a one for us considering all our modules and components dependencies if we don't have one
// The  difference between the Component.Builder and Component.Factory is that the Builder uses the Builder pattern
//Where values are concatenated while the Factory specifyings all values into the parameter of the function
//@BindInstance is normally in Component Builders and Factories
@Module
abstract class OneLicenceAndPouch{

    companion object{

        @Provides
        @IntoSet
        fun providesALicensce():String ="Birth Certificate"


        @Provides
        @IntoMap
        @StringKey("kidpouch") //For Maps we specify the keys as annotations of either Strings , primitives or Classes
        //We can also create our own
        fun provideKidPouchNumber():Int = 89

    }

}
 @Module
class ManyLicencesAndPouch{
    @Provides
    @ElementsIntoSet //This is to provides many elements into the set
    fun providesListofCerificates():Set<String> = setOf("National Certifcate","Birth Certifcate")

     @Provides
     @IntoMap
     @StringKey("front_pouch")
     fun provideFrontPouchNumber():Int = 90
}