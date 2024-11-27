package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

class GamesDbLocalDataSource(private val gameDao: GameDao, private val playerDao: PlayerDao)  {

    fun getAll(): List<Game> {
        return gameDao.getAll().map {
            it.toModel()
        }
    }

    fun save(games: List<Game>) {
        gameDao.save(*games.map { it.toEntity() }.toTypedArray())
    }

    fun savePlayers(players: List<Player>) {
        playerDao.save(*players.map { it.toEntity() }.toTypedArray())
    }

    fun getAllPlayers(): List<Player> {
        return playerDao.getAll().map { it.toModel() }
    }

}