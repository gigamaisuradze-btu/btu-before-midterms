package com.example.lecture1.app

import android.app.Application
import com.example.lecture1.database.AppDatabase
import com.example.lecture1.database.ClothingDao

class App : Application() {
    lateinit var clothingDao: ClothingDao
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        clothingDao = AppDatabase.get(this).clothingDao()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}