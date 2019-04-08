package com.test.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter


/**
 * @describe 简单的baseadapter
 *
 * @author weiran
 *
 * @date on 2017/8/14
 */

abstract class SimpleBaseAdapter<T>(var mEntities: MutableList<T>) : BaseAdapter() {
    var mContext: Context? = null

    override fun getCount(): Int = mEntities.size

    override fun getItem(position: Int): T = mEntities[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val mView: View
        if (convertView == null) {
            mView = LayoutInflater.from(parent.context).inflate( itemLayout(), parent, false)
            bindView(mView)
            mContext = parent.context
        } else {
            mView = convertView
        }
        initDatas(mView, mEntities[position], position)
        return mView
    }

    open fun bindView(mView: View) {
    }

    abstract fun initDatas(mView: View, bean: T, position: Int)

    abstract fun itemLayout(): Int


}
