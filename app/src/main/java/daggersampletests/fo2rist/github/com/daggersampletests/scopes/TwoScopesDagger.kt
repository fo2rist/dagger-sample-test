package daggersampletests.fo2rist.github.com.daggersampletests.scopes

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ScopeOne

@Component(modules = [ZeroModule::class])
@Singleton
interface SingletonScopedComponent {
    fun inject(obj: SingletonScopedDemo)
}

@Module
abstract class ZeroModule {
    @Binds
    abstract fun providesSingleton(obj: SingletonScoped): ISingletonScoped
}

@Component(modules = [OneModule::class])
@ScopeOne
interface SomeScopedComponent {
    fun inject(obj: SomeScopedDemo)
}

@Module
abstract class OneModule {
    @Binds
    abstract fun provideLevelOne(obj: SomeScoped): ISomeScoped
}

