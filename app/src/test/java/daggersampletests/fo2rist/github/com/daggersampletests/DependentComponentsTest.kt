package daggersampletests.fo2rist.github.com.daggersampletests

import daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent.DaggerCoreComponent
import daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent.DaggerHighLevelComponent
import daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent.DependentComponentsDemo
import daggersampletests.fo2rist.github.com.daggersampletests.util.printObjectProperties
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DependentComponentsTest {
    val demo = DependentComponentsDemo()
    val sharedCoreComponent = DaggerCoreComponent.create()

    @Test
    fun `test core component re-creation vs caching`() {
        val componentSharedCore1 = DaggerHighLevelComponent.builder()
                .coreComponent(sharedCoreComponent)
                .build()

        val componentSharedCore2 = DaggerHighLevelComponent.builder()
                .coreComponent(sharedCoreComponent)
                .build()

        val componentRecreatedCore = DaggerHighLevelComponent.builder()
                .coreComponent(DaggerCoreComponent.create())
                .build()

        componentSharedCore1.inject(demo)
        printObjectProperties(demo, "First component with Shared core component [first injection]")

        //shows that short living object is always new even for the same component instance
        componentSharedCore1.inject(demo)
        printObjectProperties(demo, "First component with Shared core component [second injection]")

        //shows how the long living object is the same because it's provided by the same core component instance
        componentSharedCore2.inject(demo)
        printObjectProperties(demo, "Second component with Shared core component")

        //shows that even the singleton long living object is different if the core component is re-created
        componentRecreatedCore.inject(demo)
        printObjectProperties(demo, "New component with New core component")
    }
}
