package com.example.fadhil3tie.data.api

import com.example.fadhil3tie.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
