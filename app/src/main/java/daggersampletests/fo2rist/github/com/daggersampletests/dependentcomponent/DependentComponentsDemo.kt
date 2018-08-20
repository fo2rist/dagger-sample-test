package daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent

import javax.inject.Inject
import javax.inject.Singleton

/**
 * This class demonstrates how dependencies are resolved by both High Level component and Core component it depends on.
 */
class DependentComponentsDemo {
    /** This is resolved by [HighLevelComponent] */
    @Inject
    lateinit var someShortLivingObject: IShortLiving

    @Inject
    lateinit var someLongLivingObject: ILongLiving
}

interface ILongLiving
@Singleton
class LongLiving @Inject constructor() : ILongLiving

interface IShortLiving
class ShortLiving @Inject constructor() : IShortLiving
