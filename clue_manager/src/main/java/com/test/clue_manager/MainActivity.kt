package com.test.clue_manager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.test.clue_manager.fragment.ClueFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manager)
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame_layout, ClueFragment())
        beginTransaction.commit()
    }
}
