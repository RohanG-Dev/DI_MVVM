package com.example.mydaggerapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mydaggerapp.module.Product
import com.example.mydaggerapp.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {


    val productLiveDataVM : LiveData<List<Product>>
    get() = repository.productLD

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}