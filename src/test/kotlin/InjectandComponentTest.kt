import DaggerDI.CarComponent
import DaggerDI.DaggerCarComponent
import DaggerDI.Engine
import DaggerDI.RoundTire
import org.junit.jupiter.api.BeforeAll
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs


class InjectandComponentTest {
     var carComponent : CarComponent = DaggerCarComponent.create()

    @Test
    fun checkWhetherCarComponent(){
        //Since we start we will test that the car instance that was injected used the proper car constructor
        val carComponent = DaggerCarComponent.create()
        val car  = carComponent.getCar()
        assertEquals(car.tires,4)
    }
    @Test
    fun fieldInjectionUsingEngineClass(){

        val car =  carComponent.getCar()
        assertIs<Engine>(car.engine)
    }
    @Test
    fun testForModulesBindsandProvides(){
       val car = carComponent.getCar()
        assertEquals(car.dashBoard.color ,4)
        //assertIs<RoundTire>(car.tire)
    }



}