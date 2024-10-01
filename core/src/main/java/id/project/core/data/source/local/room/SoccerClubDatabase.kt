package id.project.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import id.project.core.data.source.local.entity.SoccerClubEntity

@Database(
    entities = [SoccerClubEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SoccerClubDatabase : RoomDatabase() {
    abstract fun soccerClubDao() : SoccerClubDao
}