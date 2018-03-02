package daggersampletests.fo2rist.github.com.daggersampletests

import android.support.test.runner.AndroidJUnit4
import dagger.Component
import dagger.Module
import dagger.Provides
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Singleton

@RunWith(AndroidJUnit4::class)
class DaggerTest {

    interface IPlain
    class PlainClass @Inject constructor() : IPlain

    interface IPlainBound
    class PlainBoundClass @Inject constructor() : IPlainBound

    interface ISingleton
    @Singleton
    class SingletonClass @Inject constructor() : ISingleton

    interface ISingletonBound
    @Singleton
    class SingletonBoundClass @Inject constructor() : ISingletonBound

    interface ISingletonProvided
    class SingletonProvided @Inject constructor() : ISingletonProvided

    interface IFullSingleton
    @Singleton
    class FullSingleton @Inject constructor() : IFullSingleton

    @Component(modules = arrayOf(TestModule::class))
    @Singleton
    interface TestComponent {
        fun inject(t: DaggerTest)
    }


    @Inject
    lateinit var plain: IPlain
    @Inject
    lateinit var plainBound: IPlainBound
    @Inject
    lateinit var singletonClass: ISingleton
    @Inject
    lateinit var singletonBoundClass: ISingletonBound
    @Inject
    lateinit var singletonProvider: ISingletonProvided
    @Inject
    lateinit var fullSingleton: IFullSingleton

    //Test module that shows in which cases objects are reused and in which cases they're recreated
    @Module
    class TestModule {
        //Always new
        @Provides
        fun provideP() : IPlain = PlainClass()

        //Always new as well
        @Provides
        fun providePB(binding: PlainBoundClass) : IPlainBound = binding

        //Always new because it's created in call not resolved
        @Provides
        fun provideS() : ISingleton = SingletonClass()

        //Same for the same component because class is singleton and it's resolved by dagger
        @Provides
        fun provideSB(binding: SingletonBoundClass) : ISingletonBound = binding

        //Same because the provides method is annotated as singleton
        @Provides
        @Singleton
        fun provideSP() : ISingletonProvided = SingletonProvided()

        //Same and both provider method and class are annotated
        @Provides
        @Singleton
        fun provideF() : IFullSingleton = FullSingleton()
    }

    @Test
    fun testComponents() {
        val testComponent1 = DaggerDaggerTest_TestComponent.create()
        testComponent1.inject(this)
        val injectedOnceSignature = createSignature()

        testComponent1.inject(this)
        val injectedTwiceSignature = createSignature()

        val testComponent2 = DaggerDaggerTest_TestComponent.create()
        testComponent2.inject(this)
        val injectedByNewComponentSignature = createSignature()

        System.out.println("\n1st injection")
        System.out.println(injectedOnceSignature)
        System.out.println("\n2nd injection")
        System.out.println(injectedTwiceSignature)
        System.out.println("\nNew injection")
        System.out.println(injectedByNewComponentSignature)
    }

    private fun createSignature(): String {
        return plain?.toString() + "\n" +
                plainBound?.toString() + "\n" +
                singletonClass?.toString() + "\n" +
                singletonBoundClass?.toString() + "\n" +
                singletonProvider?.toString() + "\n" +
                fullSingleton?.toString()
    }
}
