package com.devinet2.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.devinet2.model.Categorie
import com.devinet2.model.Mot

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 */

@Dao
interface MotDao {

    /**
     * Fonction qui donne une liste de mots triés par longueur du mot puis par catégorie
     */
    @Query ("SELECT * " +
            "FROM mots m " +
            "INNER JOIN categories c " +
            "ON (m.categorie = c.id) " +
            "ORDER BY length(m.mot), c.nom")
    fun getMotsTries():List<Mot>

    /**
     * Fonction qui donne une liste de mot en fonction de la longueur du mot et de sa catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=:size)")
    fun getMotsBySize(size: Long, cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui réinitialise la proposition via l'id (gomme lors du jeu)
     */
    @Query ("UPDATE mots " +
            "SET proposition = null " +
            "WHERE id=:mot_id")
    fun initProposition(mot_id: Long)

    /**
     * Fonction qui réinitialise le niveau n°i
     * Penser à mettre i>0
     */
    @Query ("UPDATE mots " +
            "SET proposition = null " +
            "WHERE length(mot)=((:i)+3)")
    fun initAllPropositionsByNiveau(i: Long)

    /**
     * Fonction qui permet d'insérer un objet Mot.
     */
    @Insert
    fun insertMot(mot: Mot)

    /**
     * Fonction qui permet de modifier un objet Mot.
     */
    @Update
    fun updateMot(mot: Mot)

    /**
     * Fonction qui permet de supprimer un objet Mot.
     */
    @Delete
    fun deleteMot(mot: Mot)

}