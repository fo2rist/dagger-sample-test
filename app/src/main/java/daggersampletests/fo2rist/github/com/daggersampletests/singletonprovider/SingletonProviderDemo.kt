package daggersampletests.fo2rist.github.com.daggersampletests.singletonprovider

import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class demonstrates how different dependencies are created and injected by dagger.
 */
class SingletonProviderDemo {

    @Inject
    lateinit var unscoped: IUnscoped

    @Inject
    lateinit var unscopedBound: IUnscopedBound

    @Inject
    lateinit var singleton: ISingleton

    @Inject
    lateinit var singletonBound: ISingletonBound

    @Inject
    lateinit var providedAsSingleton: IProvidedAsSingleton

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
