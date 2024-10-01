package id.project.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.project.core.data.source.local.room.SoccerClubDao
import id.project.core.data.source.local.room.SoccerClubDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SoccerClubDatabase =
        Room.databaseBuilder(
            context = context,
            SoccerClubDatabase::class.java,
            "SoccerClub.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideSoccerClubDao(database: SoccerClubDatabase): SoccerClubDao = database.soccerClubDao()
}