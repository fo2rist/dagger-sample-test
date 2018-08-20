package daggersampletests.fo2rist.github.com.daggersampletests.dependentcomponent

import dagger.Binds
import dagger.Component
import dagger.Module
import javax.inject.Scope

/**
 * Custom scope that serves as the marker for components that want to depend on other scoped components.
 */
@Retention
@Scope
annotation class HighLevelScope

/**
 * Scoped High Level component that has its own module and also depends on [CoreComponent].
 * Scope is required because only scoped components can depend on scoped component and Core is a Singleton.
 */
@HighLevelScope
@Component(dependencies = [CoreComponent::class], modules = [HighLevelModule::class])
interface HighLevelComponent {
    fun inject(obj: DependentComponentsDemo)
}

@Module
interface HighLevelModule {
    @Binds
    fun provideShortLiving(obj: ShortLiving): IShortLiving
}
