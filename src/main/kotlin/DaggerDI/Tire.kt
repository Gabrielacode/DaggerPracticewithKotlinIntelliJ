package DaggerDI

import javax.inject.Inject

interface Tire {
}
class RoundTire @Inject constructor():Tire{

}

class DashBoard private constructor(val sterringSize:Int,val color:Int){
    //We will create a builder for example
    override fun toString(): String {
        return "Steering Size : $sterringSize Color of Dashboard :$color"
    }
    class Builder(){
       private var steering = 0

        private var color = 3
        fun steeringSize(size:Int):Builder{
            this.steering = size
            return this
        }
        fun setColor(color:Int):Builder{
            this.color = color
            return this
        }
         fun build ():DashBoard{
             return DashBoard(this.steering,this.color)
         }
    }
}