package com.example.lecture1.network

import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.lecture1.model.ClothingItem

class ClothingRepository {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun getClothes(): NetworkResult<List<ClothingItem>> {
        return Helper.makeApiCall {
            RetrofitClient.api.getClothes()
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun postClothFavorite(id: Int): NetworkResult<Unit> {
        return Helper.makeApiCall {
            RetrofitClient.api.postFavoriteCloth(id)
        }
    }
}