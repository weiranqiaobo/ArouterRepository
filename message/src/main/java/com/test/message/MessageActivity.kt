package com.test.message

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.test.base.utils.RouteUtils
import com.test.message.fragment.MessageFragment

@Route(path = RouteUtils.Chat_ForResult)
class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        val fragmentManager = supportFragmentManager
        val beginTransaction = fragmentManager.beginTransaction()
        beginTransaction.replace(R.id.frameLayout, MessageFragment())
        beginTransaction.commit()
    }
}
