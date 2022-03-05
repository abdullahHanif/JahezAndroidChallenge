package net.jahez.jahezchallenge.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.jahez.data.db.JahezDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): JahezDatabase =
        Room.databaseBuilder(context, JahezDatabase::class.java, JahezDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Singleton
    @Provides
    fun provideRestaurantDao(db: JahezDatabase) = db.restaurantDao()

}