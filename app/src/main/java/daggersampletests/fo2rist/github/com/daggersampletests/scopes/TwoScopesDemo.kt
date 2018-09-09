package daggersampletests.fo2rist.github.com.daggersampletests.scopes

import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class demonstrates the injection of a singleton.
 */
class SingletonScopedDemo {
    @Inject
    lateinit var singletonMember: ISingletonScoped

}

interface ISingletonScoped
@Singleton
class SingletonScoped @Inject constructor() : ISingletonScoped

/**
 * This class demonstrates the injection of of a custom-scoped object with works the same way
 * as the singleton injection.
 */
class SomeScopedDemo {
    @Inject
    lateinit var someScopedMember: ISomeScoped
}


interface ISomeScoped
@ScopeOne
class SomeScoped @Inject constructor() : ISomeScoped
