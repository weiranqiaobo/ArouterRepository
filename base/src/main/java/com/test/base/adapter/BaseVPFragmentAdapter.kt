package com.test.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by suki on 2017/8/7.
 */

class BaseVPFragmentAdapter(fm: FragmentManager, private val list: List<Fragment>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = list[position]

    override fun getCount(): Int = list.size
}
