package com.example.lecture1.network

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.lecture1.app.App
import com.example.lecture1.database.toApiModel
import com.example.lecture1.database.toDatabase
import com.example.lecture1.model.ClothingItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClothingRepository {
    private val database = App.instance.clothingDao
    private val network = RetrofitClient.api

    fun getClothesFromDB(): Flow<List<ClothingItem>> = database.getAllClothes().map {
        list -> list.map { it.toApiModel() }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getClothes(): NetworkResult<Unit> {
        return when (val result = Helper.makeApiCall {
            network.getClothes()
        }) {
            is NetworkResult.Success -> {
                database.insertItems(result.data.map { it.toDatabase() })
                NetworkResult.Success(Unit)
            }

            is NetworkResult.Failure -> {
                NetworkResult.Failure(result.message)
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun postClothFavorite(id: Int, favorite: Boolean): NetworkResult<Unit> {
        database.setFavorite(id = id, favorite = favorite)
        return NetworkResult.Success(Unit)
    }
}