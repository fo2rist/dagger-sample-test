package daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Component(modules = [SingletonProvidingModule::class])
@Singleton
interface SingletonProvidingComponent {
    fun inject(into: SingletonProviderDemo)
}

/**
 * Module that demonstrates different techniques of providing dependencies.
 * Meaning of provider suffixes:
 * - Unscoped means the class in not scoped
 * - Bound means the class is bound to implementation implicitly via provider parameter type
 * - Singleton mean the class is Singleton scoped
 * - AsSingleton mean the provider is marked as Singleton
 */
@Module
class SingletonProvidingModule {

    /**
     * This is always created even within single component because neither class nor provider are scoped.
     * @see SingletonProvidingModule.provideUnscoped
     */
    @Provides
    fun provideUnscoped() : IUnscoped = Unscoped()

    /**
     * This is always created even within single component because neither class nor provider are scoped.
     * Even though there is no explicit constructor invocation in the module code the new instance is
     * created by dagger.
     * @see SingletonProvidingModule.provideUnscopedBound
     */
    @Provides
    fun provideUnscopedBound(binding: UnscopedBound) : IUnscopedBound = binding

    /**
     * This is always new because the constructor is explicitly called in module even though the class is annotated.
     * @see SingletonProvidingModule.provideSingleton
     */
    @Provides
    fun provideSingleton() : ISingleton = SingletonClass()

    /**
     * This is retained within the component because class is singleton and its creation is resolved by dagger.
     * @see SingletonProvidingModule.provideSingletonBound
     */
    @Provides
    fun provideSingletonBound(binding: SingletonBound) : ISingletonBound = binding

    /**
     * This is retained within the component because the provider method is annotated as singleton.
     * Even though the class is scope-less provider level annotation is enough.
     * @see SingletonProvidingModule.provideAsSingleton
     */
    @Provides
    @Singleton
    fun provideAsSingleton() : IProvidedAsSingleton = ProvidedAsSingleton()

    /**
     * This is retained within the component because the provider method and class are scoped.
     * @see SingletonProvidingModule.provideSingletonAsSingleton
     */
    @Provides
    @Singleton
    fun provideSingletonAsSingleton() : ISingletonProvidedAsSingleton = SingletonProvidedAsSingleton()
}

