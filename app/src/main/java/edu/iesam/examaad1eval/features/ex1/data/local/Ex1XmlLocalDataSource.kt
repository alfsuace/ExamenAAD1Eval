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
            users.forEach {
                putString(it.id, gson.toJson(it))
            }
        }
    }

    fun getUsers(): List<User> {
        val users = mutableListOf<User>()
        sharedPref.all.values.forEach {
            users.add(gson.fromJson(it as String, User::class.java))
        }
        return users
    }

    fun saveItems(items: List<Item>) {
        sharedPref.edit {
            items.forEach {
                putString(it.id, gson.toJson(it))
            }
        }
    }

    fun getItems(): List<Item> {
        val items = mutableListOf<Item>()
        sharedPref.all.values.forEach {
            items.add(gson.fromJson(it as String, Item::class.java))
        }
        return items
    }

    fun saveServices(services: List<Services>) {
        sharedPref.edit {
            services.forEach {
                putString(it.id, gson.toJson(it))
            }
        }
    }

    fun getServices(): List<Services> {
        val services = mutableListOf<Services>()
        sharedPref.all.values.forEach {
            services.add(gson.fromJson(it as String, Services::class.java))
        }
        return services
    }
}