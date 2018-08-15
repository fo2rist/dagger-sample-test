package daggersampletests.fo2rist.github.com.daggersampletests

import daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider.DaggerSingletonProvidingComponent
import daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider.SingletonProviderDemo
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
        printInstanceMembers(demo1, "1st injection")

        //show how scoped dependencies cached by component
        testComponent1.inject(demo1)
        printInstanceMembers(demo1, "2nd injection via same Component")

        //show how singleton is component-local
        testComponent2.inject(demo1)
        printInstanceMembers(demo1, "Injection via new Component")

        //show how component is object-agnostic and works the same way with any objects
        testComponent2.inject(demo2)
        printInstanceMembers(demo2, "Injection into new Object via new Component")
    }

    private fun printInstanceMembers(demoInstance: SingletonProviderDemo, title: String = "") {
        System.out.println("\n" + title)
        System.out.println(listOf(
                demoInstance.unscoped,
                demoInstance.unscopedBound,
                demoInstance.singleton,
                demoInstance.singletonBound,
                demoInstance.providedAsSingleton,
                demoInstance.singletonProvidedAsSingleton
        ).joinToString("\n"))
    }
}
