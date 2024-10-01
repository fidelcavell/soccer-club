package id.project.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import id.project.core.data.source.local.entity.SoccerClubEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SoccerClubDao {
    @Query("select * from soccer_club")
    fun getAllSoccerClub(): Flow<List<SoccerClubEntity>>

    @Query("select * from soccer_club where isFavorite = 1")
    fun getAllFavoriteSoccerClub(): Flow<List<SoccerClubEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSoccerClubs(soccerClubList: List<SoccerClubEntity>)

    @Update
    fun updateFavoriteSoccerClub(soccerClub: SoccerClubEntity)
}