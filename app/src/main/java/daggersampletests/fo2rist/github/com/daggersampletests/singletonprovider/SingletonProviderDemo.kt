package daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider

import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class demonstrates how different dependencies are created and injected by dagger.
 */
class SingletonProviderDemo {
    /**
     * This is always created even within single component because neither class nor provider are scoped.
     * @see SingletonProvidingModule.provideUnscoped
     */
    @Inject
    lateinit var unscoped: IUnscoped

    /**
     * This is always created even within single component because neither class nor provider are scoped.
     * Even though there is no explicit constructor invocation in the module code the new instance is
     * created by dagger.
     * @see SingletonProvidingModule.provideUnscopedBound
     */
    @Inject
    lateinit var unscopedBound: IUnscopedBound

    /**
     * This is always new because the constructor is explicitly called in module even though the class is annotated.
     * @see SingletonProvidingModule.provideSingleton
     */
    @Inject
    lateinit var singleton: ISingleton

    /**
     * This is retained within the component because class is singleton and its creation is resolved by dagger.
     * @see SingletonProvidingModule.provideSingletonBound
     */
    @Inject
    lateinit var singletonBound: ISingletonBound

    /**
     * This is retained within the component because the provider method is annotated as singleton.
     * Even though the class is scope-less provider level annotation is enough.
     * @see SingletonProvidingModule.provideAsSingleton
     */
    @Inject
    lateinit var providedAsSingleton: IProvidedAsSingleton

    /**
     * This is retained within the component because the provider method and class are scoped.
     * @see SingletonProvidingModule.provideSingletonAsSingleton
     */
    @Inject
    lateinit var singletonProvidedAsSingleton: ISingletonProvidedAsSingleton
}

interface IUnscoped
class Unscoped @Inject constructor() : IUnscoped

interface IUnscopedBound
class UnscopedBound @Inject constructor() : IUnscopedBound

interface ISingleton
@Singleton
class SingletonClass @Inject constructor() : ISingleton

interface ISingletonBound
@Singleton
class SingletonBound @Inject constructor() : ISingletonBound

interface IProvidedAsSingleton
class ProvidedAsSingleton @Inject constructor() : IProvidedAsSingleton

interface ISingletonProvidedAsSingleton
@Singleton
class SingletonProvidedAsSingleton @Inject constructor() : ISingletonProvidedAsSingleton
