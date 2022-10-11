package com.example.mydaggerapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mydaggerapp.module.FakerApi
import com.example.mydaggerapp.module.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi){

    private val _productsMLD = MutableLiveData<List<Product>>()
    val productLD : LiveData<List<Product>>
     get() = _productsMLD


    suspend fun getProducts()
    {
        val result = fakerApi.getProducts()
        if(result.isSuccessful && result.body()!=null)
        {
            _productsMLD.postValue(result.body())
        }
    }

}