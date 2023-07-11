package com.example.hw0306

import android.app.Application
import com.example.hw0306.repository.Repository

class App : Application (){
companion object
    val repository = Repository()
}