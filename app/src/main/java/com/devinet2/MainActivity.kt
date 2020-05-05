package com.devinet2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.facebook.stetho.Stetho

/**
 * auteur: Magalie DESAIZE le 04/05/2020
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Stetho.initializeWithDefaults(this)
        setContentView(R.layout.activity_main)
    }
}
