package com.example.apppaises.repositories

import com.example.apppaises.datasources.RetrofitInstance
import com.example.apppaises.model.Country

class CountryRepository {
    private val api = RetrofitInstance.api

    suspend fun getCountries():List<Country>{
        var result = api.getAllCountries()
        return result
    }

    suspend fun addCountry(country: Country){
        api.addCountry(country)
    }
}