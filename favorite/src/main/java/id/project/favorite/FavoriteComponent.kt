package id.project.favorite

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import id.project.soccerclub.di.FavoriteModuleDependencies

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }

    fun inject(favoriteFragment: FavoriteFragment)
}