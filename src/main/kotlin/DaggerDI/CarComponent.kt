package DaggerDI

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [TireAndDashBoardModule::class])
interface CarComponent {
    fun getCar():Car
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