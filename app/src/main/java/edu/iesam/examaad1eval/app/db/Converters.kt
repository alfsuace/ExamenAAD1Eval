package edu.iesam.examaad1eval.app.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex2.domain.Player
import java.util.Date

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromPlayerList(players: List<Player>): String {
        return gson.toJson(players)
    }

    @TypeConverter
    fun toPlayerList(playersString: String): List<Player> {
        return gson.fromJson(playersString, Array<Player>::class.java).toList()
    }

}