package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.app.db.DbProvider
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GamesDbLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        val dataRepo= Ex1DataRepository(
            MockEx1RemoteDataSource(),
            Ex1XmlLocalDataSource(this)
        )

        Log.d("@Dev", dataRepo.getUsers().toString())
        Log.d("@Dev", dataRepo.getItems().toString())
        Log.d("@Dev", dataRepo.getServices().toString())
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            val db = Ex2DataRepository(
                MockEx2RemoteDataSource(),
                GamesDbLocalDataSource(
                   DbProvider.provideDb(this@MainActivity).gameDao(),
                   DbProvider.provideDb(this@MainActivity).playerDao(),
                )
            )
            Log.d("@Dev", db.getGames().toString())
        }
    }
}