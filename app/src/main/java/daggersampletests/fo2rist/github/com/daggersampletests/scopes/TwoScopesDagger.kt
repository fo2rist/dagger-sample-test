package daggersampletests.fo2rist.github.com.daggersampletests.scopes

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope
import javax.inject.Singleton

@Scope
annotation class ScopeOne

/**
 * The component that injects a singleton.
 */
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

/**
 * The component that injects a single custom-scoped objects.
 * This component does exactly the same as [SingletonScopedComponent] because for Dagger all scoped objects
 * are equals and it generates the same code for all scoped providers (with minor exception of special
 * [dagger.Reusable] scope.
 */
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

