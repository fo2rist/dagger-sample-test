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

    @Provides
    fun provideUnscoped() : IUnscoped = Unscoped()

    @Provides
    fun provideUnscopedBound(binding: UnscopedBound) : IUnscopedBound = binding

    @Provides
    fun provideSingleton() : ISingleton = SingletonClass()

    @Provides
    fun provideSingletonBound(binding: SingletonBound) : ISingletonBound = binding

    @Provides
    @Singleton
    fun provideAsSingleton() : IProvidedAsSingleton = ProvidedAsSingleton()

    @Provides
    @Singleton
    fun provideSingletonAsSingleton() : ISingletonProvidedAsSingleton = SingletonProvidedAsSingleton()
}

