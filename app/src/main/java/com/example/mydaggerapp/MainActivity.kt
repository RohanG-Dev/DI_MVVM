package com.example.mydaggerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mydaggerapp.viewmodels.MainViewModel
import com.example.mydaggerapp.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    val productsText : TextView
    get() = findViewById(R.id.productText)

    @Inject
    lateinit var  mainViewModelFactory:MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]

        mainViewModel.productLiveDataVM.observe(this,Observer{
            productsText.text = it.joinToString { x -> x.title + "\n \n" }
        })

    }
}