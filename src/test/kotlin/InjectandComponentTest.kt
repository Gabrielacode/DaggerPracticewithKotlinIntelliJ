import DaggerDI.DaggerCarComponent
import kotlin.test.Test
import kotlin.test.assertEquals


class InjectandComponentTest {
    @Test
    fun checkWhetherCarComponent(){
        //Since we start we will test that the car instance that was injected used the proper car constructor
        val carComponent = DaggerCarComponent.create()
        val car  = carComponent.getCar()
        assertEquals(car.tires,4)
    }
}