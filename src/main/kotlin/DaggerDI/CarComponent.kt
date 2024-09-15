package DaggerDI

import dagger.Component

@Component
interface CarComponent {
    fun getCar():Car
}