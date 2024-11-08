package com.example.apppaises.datasources

import com.example.apppaises.model.Country
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CountryApiService{
    @GET("api/Country")
    suspend fun getAllCountries():List<Country>

    @POST("api/Country")
    suspend fun addCountry(@Body country: Country)

}