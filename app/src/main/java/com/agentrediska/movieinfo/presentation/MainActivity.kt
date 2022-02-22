package com.agentrediska.movieinfo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agentrediska.movieinfo.R
import com.agentrediska.movieinfo.presentation.screen.film.ListFilmsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListFilmsFragment())
            .commit()
    }
}