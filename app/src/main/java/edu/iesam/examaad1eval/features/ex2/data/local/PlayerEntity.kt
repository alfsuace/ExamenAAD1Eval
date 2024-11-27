package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val PLAYER_TABLE = "player"
@Entity(tableName = PLAYER_TABLE)
data class PlayerEntity (
    @PrimaryKey @ColumnInfo(name = "id") val id,
    @ColumnInfo(name = "name") val name: String

)