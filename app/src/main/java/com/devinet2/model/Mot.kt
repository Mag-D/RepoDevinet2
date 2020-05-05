package com.devinet2.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 */

@Entity(tableName = "Mots")
data class Mot (@PrimaryKey(autoGenerate = true) var id: Long,
                var img:String,
                var mot:String,
                var proposition:String?,
                var categorie: Long)
