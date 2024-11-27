package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val remoteDataSource: MockEx1RemoteDataSource,
    private val localDataSource: Ex1XmlLocalDataSource
): Ex1Repository {
    override fun getUsers(): List<User> {
        val users = localDataSource.getUsers()
        if (users.isEmpty()) {
            val usersFromRemote = remoteDataSource.getUsers()
            localDataSource.saveUsers(usersFromRemote)
            return usersFromRemote
        }else{
            return users
        }
    }

    override fun getItems(): List<Item> {
        val items = localDataSource.getItems()
        if (items.isEmpty()) {
            val itemsFromRemote = remoteDataSource.getItems()
            localDataSource.saveItems(itemsFromRemote)
            return itemsFromRemote
        }else{
            return items
        }
    }

    override fun getServices(): List<Services> {
        val services = localDataSource.getServices()
        if (services.isEmpty()) {
            val servicesFromRemote = remoteDataSource.getServices()
            localDataSource.saveServices(servicesFromRemote)
            return servicesFromRemote
        }else{
            return services
        }
    }
}