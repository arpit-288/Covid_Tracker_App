package com.example.covid19trackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covid19trackerapp.model.MainViewModel
import com.example.covid19trackerapp.model.MainViewModelFactory
import com.example.covid19trackerapp.model.Repository

class MainActivity: AppCompatActivity() {

    lateinit var txtaffected:TextView
    lateinit var txtactive:TextView
    lateinit var txtrecovered:TextView
    lateinit var txtdeath:TextView
    lateinit var txtserious:TextView
    lateinit var globalVaccine:TextView
    lateinit var imageView:ImageView
   private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)


       txtactive = findViewById(R.id.txtactive)
        txtserious = findViewById(R.id.txtserious)
        txtrecovered = findViewById(R.id.txtrecovered)
        txtdeath = findViewById(R.id.txtdeath)
        txtaffected = findViewById(R.id.txtaffected)
        imageView = findViewById(R.id.imageView)

        val repository = Repository()

        val viewModelFactory = MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getapidata()
        viewModel.myResponce.observe(this, Observer {responce->

            txtactive.setText(responce.active.toString())
            txtaffected.setText(responce.cases.toString())
            txtdeath.setText(responce.deaths.toString())
            txtrecovered.setText(responce.recovered.toString())
            txtserious.setText(responce.critical.toString())



        })


    }

}