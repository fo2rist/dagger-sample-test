package daggersampletests.fo2rist.github.com.daggersampletests

import daggersampletests.fo2rist.github.com.daggersampletests.scopes.DaggerSingletonScopedComponent
import daggersampletests.fo2rist.github.com.daggersampletests.scopes.DaggerSomeScopedComponent
import daggersampletests.fo2rist.github.com.daggersampletests.scopes.SingletonScopedDemo
import daggersampletests.fo2rist.github.com.daggersampletests.scopes.SomeScopedDemo
import daggersampletests.fo2rist.github.com.daggersampletests.util.printObjectProperties
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TwoScopesTest {

    private val singletonComponent = DaggerSingletonScopedComponent.create()
    private val demoSingleton = SingletonScopedDemo()

    private val someComponent = DaggerSomeScopedComponent.create()
    private val demoSome = SomeScopedDemo()

    @Test
    fun testDifferentScopes() {
        singletonComponent.inject(demoSingleton)
        printObjectProperties(demoSingleton, "Singleton Scope [first injection]")

        singletonComponent.inject(demoSingleton)
        printObjectProperties(demoSingleton, "Singleton Scope [second injection]")

        someComponent.inject(demoSome)
        printObjectProperties(demoSome, "Custom Scope [first injection]")

        someComponent.inject(demoSome)
        printObjectProperties(demoSome, "Custom Scope [second injection]")
    }
}
