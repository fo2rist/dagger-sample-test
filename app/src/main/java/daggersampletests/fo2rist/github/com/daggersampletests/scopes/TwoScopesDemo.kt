package daggersampletests.fo2rist.github.com.daggersampletests.scopes

import javax.inject.Inject
import javax.inject.Singleton

class SingletonScopedDemo {
    @Inject
    lateinit var singletonMember: ISingletonScoped

}

interface ISingletonScoped
@Singleton
class SingletonScoped @Inject constructor() : ISingletonScoped

class SomeScopedDemo {
    @Inject
    lateinit var someScopedMember: ISomeScoped
}


interface ISomeScoped
@ScopeOne
class SomeScoped @Inject constructor() : ISomeScoped
