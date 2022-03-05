package net.jahez.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import net.jahez.data.db.dao.RestaurantDao
import net.jahez.data.model.Restaurant
import net.jahez.data.model.typeconverter.TypeConverterz

@Database(entities = [Restaurant::class], version = 1, exportSchema = false)
abstract class  JahezDatabase : RoomDatabase() {
    abstract fun restaurantDao(): RestaurantDao

    companion object {
        val DATABASE_NAME: String = "jahez_db"
    }
}