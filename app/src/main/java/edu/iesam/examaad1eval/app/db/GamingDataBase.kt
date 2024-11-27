package edu.iesam.examaad1eval.app.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.data.local.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.local.PlayerDao

@Database(entities = [GameEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class GamingDataBase: RoomDatabase(){
    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao

}