package com.devinet2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
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
     * Fonction qui donne une liste de mot de 4 lettres en tenant compte de la catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=4)")
    fun getMotNiveau1(cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui donne une liste de mot de 5 lettres en tenant compte de la catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=5)")
    fun getMotNiveau2(cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui donne une liste de mot de 6 lettres en tenant compte de la catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=6)")
    fun getMotNiveau3(cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui donne une liste de mot de 7 lettres en tenant compte de la catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=7)")
    fun getMotNiveau4(cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui donne une liste de mot de 8 lettres en tenant compte de la catégorie
     */
    @Query ("SELECT * " +
            "FROM mots " +
            "INNER JOIN categories " +
            "ON (mots.categorie = categories.id) " +
            "WHERE (categories.id = :cat_id AND length(:mot)=8)")
    fun getMotNiveau5(cat_id: Long, mot: String):List<Mot>

    /**
     * Fonction qui permet de proposer un mot
     */
    @Query ("UPDATE mots " +
            "SET proposition = :proposition " +
            "WHERE mots.id=:mot_id")
    fun updateProposition(mot_id: Long, proposition:String)

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


}