package com.example.lecture1.network

import com.example.lecture1.model.ClothingItem
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClothingApi {
    @GET("/api/clothes")
    suspend fun getClothes() : List<ClothingItem>

    @POST("/api/clothes")
    suspend fun postFavoriteCloth(@Body id: Int)
}