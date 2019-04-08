package com.test.me

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.test.me.fragment.MeFragment

class MeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_me)
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frame_layout, MeFragment())
        beginTransaction.commit()
    }
}
