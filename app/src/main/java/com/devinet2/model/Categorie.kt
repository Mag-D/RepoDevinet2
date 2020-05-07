package com.devinet2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 *
 * Cette classe permet de qualifier un mot à l'aide d'une catégorie
 */

@Entity(tableName = "categories")
data class Categorie (@PrimaryKey(autoGenerate = true) var id: Long,
                      var nom:String)
