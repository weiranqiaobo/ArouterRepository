package com.test.base.basecomponent

/**
 *@Date 2018/5/19
 *@Author Mr.WEI
 *@Description  baseView接口
 **/
interface IBaseView {

    /**
     * 开始show 加载dialog
     */
    fun showLoading()

    /**
     * 销毁dismiss dialog
     */
    fun dismissLoading()

}
