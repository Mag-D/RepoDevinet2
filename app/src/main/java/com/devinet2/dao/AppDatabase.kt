package com.devinet2.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devinet2.model.Categorie
import com.devinet2.model.Mot

@Database(entities = [Mot::class, Categorie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun motDao(): MotDao
    abstract fun categorieDao(): CategorieDao
}