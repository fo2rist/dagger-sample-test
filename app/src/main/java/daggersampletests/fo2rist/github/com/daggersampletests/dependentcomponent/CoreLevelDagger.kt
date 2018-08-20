package daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Singleton

/**
 * Scoped Singleton component that can be used as a dependency by another component.
 * Singleton scope is required because provided implementation [LongLiving] is a Singleton.
 */
@Component(modules = [CoreModule::class])
@Singleton
interface CoreComponent {
    //provider in the component itself required to expose [ILongLiving] to the components that depend on [CoreComponent]
    fun provideLongLiving(): ILongLiving
}

@Module
interface CoreModule {
    @Binds
    fun provideLongLiving(obj: LongLiving): ILongLiving
}
