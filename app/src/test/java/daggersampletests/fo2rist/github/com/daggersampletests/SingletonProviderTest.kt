package daggersampletests.fo2rist.github.com.daggersampletests

import daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider.DaggerSingletonProvidingComponent
import daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider.SingletonProviderDemo
import daggersampletests.fo2rist.github.com.daggersampletests.util.printObjectProperties
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SingletonProviderTest {

    val demo1 = SingletonProviderDemo()
    val demo2 = SingletonProviderDemo()
    val testComponent1 = DaggerSingletonProvidingComponent.create()
    val testComponent2 = DaggerSingletonProvidingComponent.create()

    @Test
    fun `test unscoped and singleton scoped dependencies injection`() {
        testComponent1.inject(demo1)
        printObjectProperties(demo1, "1st injection")

        //show how scoped dependencies cached by component
        testComponent1.inject(demo1)
        printObjectProperties(demo1, "2nd injection via same Component")

        //show how singleton is component-local
        testComponent2.inject(demo1)
        printObjectProperties(demo1, "Injection via new Component")

        //show how component is object-agnostic and works the same way with any objects
        testComponent2.inject(demo2)
        printObjectProperties(demo2, "Injection into new Object via new Component")
    }
}
