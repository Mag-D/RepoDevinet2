package com.devinet2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devinet2.model.Categorie

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 */

@Dao
interface CategorieDao {

    @Query ("SELECT * FROM categories")
    fun getAllCategories(): List<Categorie>

    @Query ("SELECT * FROM categories where id= :id")
    fun findByCategorie(id:Long): Categorie

    @Insert
    fun insertCategorie(categorie: Categorie)

    @Update
    fun updateCategorie(categorie: Categorie)

    @Delete
    fun deleteCategorie(categorie: Categorie)
}