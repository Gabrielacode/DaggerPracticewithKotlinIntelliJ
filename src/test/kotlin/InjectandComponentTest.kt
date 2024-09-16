import DaggerDI.CarComponent
import DaggerDI.DaggerCarComponent
import DaggerDI.Engine
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import kotlin.test.assertNotEquals


class InjectandComponentTest {
     var carComponent : CarComponent = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine()).buildCarComponent()

    @Test
    fun checkWhetherCarComponent(){
        //Since we start we will test that the car instance that was injected used the proper car constructor
        val carComponent = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine()).buildCarComponent()
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

    @Test
    fun useScopeAnnotations (){
        val car1 = carComponent.getCar()
        val car2 = carComponent.getCar()
        assertEquals(car1,car2)
        val carComponent2 = DaggerCarComponent.builder().buildCarComponent()
        val car3  = carComponent2.getCar()
        assertNotEquals(car3,car1)
    }

    @Test
    fun useSubComponents(){
        val mechanicRoomComponent = carComponent.getMechanicRoom().build()
        assertEquals(mechanicRoomComponent.getEngine().valves,carComponent.getCar().engine.valves)
    }

    @Test
    fun useBindsInstanceforEngine(){
        val carComponent1 = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine()).buildCarComponent()
        val customCarCompont = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine().apply { valves =456 }).buildCarComponent()
        assertNotEquals(carComponent1.getCar().engine.valves,customCarCompont.getCar().engine.valves)
    }

    @Test
    fun injectCustomEngineintoCarwithCustomEngine(){
        val customEngineCarComponent = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine().apply { valves = 200 }).buildCarComponent()
        val normalCarComponent = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine()).buildCarComponent()
        val normalCar = normalCarComponent.getCar()
        customEngineCarComponent.injectCar(normalCar)
        assertEquals(normalCar.engine.valves,200)
    }

    @Test
    fun usingQualifiersForSpareandMainEngine(){
        val normalCarComponent = DaggerCarComponent.builder().buildCarComponentwithCustomMainEngine(Engine()).buildCarComponent()
        val normalCar = normalCarComponent.getCar()
        assertEquals(normalCar.engine.valves,8)
        assertEquals(normalCar.spareEngine.valves,12)
    }



}