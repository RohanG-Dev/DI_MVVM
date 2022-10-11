package com.example.mydaggerapp.module

import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
   suspend fun getProducts() : Response<List<Product>>
}