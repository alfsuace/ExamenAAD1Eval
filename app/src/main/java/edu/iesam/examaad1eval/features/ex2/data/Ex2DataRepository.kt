package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.GamesDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.domain.Game

class Ex2DataRepository(
    private val remoteDataSource: MockEx2RemoteDataSource,
    private val localDataSource: GamesDbLocalDataSource
) : Ex2Repository{
    override fun getGames(): List<Game> {
        val games = localDataSource.getAll()

        if (games.isEmpty()) {
            val gamesFromRemote = remoteDataSource.getGames()
            localDataSource.save(gamesFromRemote)
            return gamesFromRemote
        }else{
            return games
        }
    }
}