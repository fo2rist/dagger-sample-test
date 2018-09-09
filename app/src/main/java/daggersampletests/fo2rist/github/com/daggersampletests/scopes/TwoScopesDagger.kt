package daggersampletests.fo2rist.github.com.daggersampletests.scopes

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ScopeOne

@Component(modules = [SingletonScopeModule::class])
@Singleton
interface SingletonScopedComponent {
    fun inject(obj: SingletonScopedDemo)
}

@Module
abstract class SingletonScopeModule {
    @Binds
    abstract fun providesSingleton(obj: SingletonScoped): ISingletonScoped
}

@Component(modules = [ScopeOneModule::class])
@ScopeOne
interface SomeScopedComponent {
    fun inject(obj: SomeScopedDemo)
}

@Module
abstract class ScopeOneModule {
    @Binds
    abstract fun provideScopeOne(obj: SomeScoped): ISomeScoped
}

