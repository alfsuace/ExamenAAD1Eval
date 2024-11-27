package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(private val context: Context) {



    private val gson = Gson()

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.ex1), Context.MODE_PRIVATE
    )


    fun saveUsers(users: List<User>) {
        sharedPref.edit {
                putString("users", gson.toJson(users))
                apply()
        }
    }

    fun getUsers(): List<User> {
        val json = sharedPref.getString("users", null)
        return if (json != null) {
            gson.fromJson(json, Array<User>::class.java).toList()
        } else {
            emptyList()
        }
    }

   fun saveItems(items: List<Item>) {
        sharedPref.edit {
            putString("items", gson.toJson(items))
            apply()
        }
   }

    fun getItems(): List<Item> {
        val json = sharedPref.getString("items", null)
        return if (json != null) {
            gson.fromJson(json, Array<Item>::class.java).toList()
        } else {
            emptyList()
        }
    }

    fun saveServices(services: List<Services>) {
        sharedPref.edit {
            putString("services", gson.toJson(services))
            apply()
        }
    }

    fun getServices(): List<Services> {
        val json = sharedPref.getString("services", null)
        return if (json != null) {
            gson.fromJson(json, Array<Services>::class.java).toList()
        } else {
            emptyList()
        }
    }

}