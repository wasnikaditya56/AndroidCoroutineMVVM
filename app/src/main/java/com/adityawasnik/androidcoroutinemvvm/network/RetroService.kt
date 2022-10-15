package com.adityawasnik.androidcoroutinemvvm.network

import com.adityawasnik.androidcoroutinemvvm.model.RecycleList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String) : RecycleList


}