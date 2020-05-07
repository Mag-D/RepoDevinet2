package com.devinet2.model


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 *
 * Cette classe contient les éléments pour réaliser le jeu.
 * Le jeu consiste à présenter une image et l'utilisateur doit écrire le mot correspondant. Il faut
 * ensuite comparer la réponse avec celle de l'utilisateur.
 *
 */

@Entity(tableName = "Mots",
        foreignKeys = arrayOf(ForeignKey(entity = Categorie::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("categorie"),
            onDelete = ForeignKey.CASCADE)))
data class Mot (@PrimaryKey(autoGenerate = true) var id: Long,
                var img:String,
                var mot:String,
                var proposition:String?,
                var categorie: Long)

