package com.devinet2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.devinet2.dao.AppDatabase
import com.devinet2.dao.CategorieDao
import com.devinet2.model.Categorie
import com.devinet2.model.Mot
import com.facebook.stetho.Stetho

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this)
        setContentView(R.layout.activity_main)

        AsyncTask.execute {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "MaBaseDeDonnees").build()
            val dao = db.categorieDao()
            val c1 = Categorie(0,"Animaux")
            val c2 = Categorie(0,"Fruits")
            dao.insertCategorie(c1)
            dao.insertCategorie(c2)
        }

        AsyncTask.execute {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "MaBaseDeDonnees").build()
            val dao = db.categorieDao()
            dao.findByCategorie(1)
        }

        AsyncTask.execute {
            val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "MaBaseDeDonnees").build()
            val dao = db.motDao()
            val m1 = Mot(0, "Img1","chat",null, 1)
            val m2 = Mot(0, "Img2","ours",null, 1)
            dao.insertMot(m1)
            dao.insertMot(m2)
        }

        AsyncTask.execute{
            val db = Room.databaseBuilder(applicationContext,
                    AppDatabase::class.java, "MaBaseDeDonnees").build()
            val dao = db.categorieDao()
            val liste = dao.getAllCategories()
            liste.forEach { item -> Log.i("XXX",item.toString())}
}

    }
}
