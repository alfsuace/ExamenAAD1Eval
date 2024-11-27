package edu.iesam.examaad1eval.app.db

import android.content.Context
import androidx.room.Room

object DbProvider {
    fun provideDb(context: Context): GamingDataBase {
        val db = Room.databaseBuilder(
            context,
            GamingDataBase::class.java, "gamingDb"
        ).build()
        return db
    }
}