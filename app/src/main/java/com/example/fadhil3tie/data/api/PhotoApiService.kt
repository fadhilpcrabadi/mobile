package com.example.fadhil3tie.data.api

import com.example.fadhil3tie.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
