package net.jahez.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.jahez.data.model.Restaurant

@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(restaurant: Restaurant): Long

    @Query("SELECT * FROM Restaurant")
    suspend fun getAll(): List<Restaurant>

    @Query("Delete FROM Restaurant")
    suspend fun truncate()
}