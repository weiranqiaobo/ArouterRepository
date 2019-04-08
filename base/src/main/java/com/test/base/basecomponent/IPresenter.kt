package com.test.base.basecomponent


/**
 *@Date 2018/5/19
 *@Author Mr.WEI
 *@Description  presenter接口
 **/
interface IPresenter<in V: IBaseView> {
    fun detachView()
    fun attachView(view: V)
}
