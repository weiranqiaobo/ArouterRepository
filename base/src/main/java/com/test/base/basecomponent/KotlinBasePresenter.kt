package com.test.base.basecomponent

/**
 *@Date 2018/5/19
 *@Author Mr.WEI
 *@Description BasePresentero
 **/
open class KotlinBasePresenter<T : IBaseView>(private var mView: T?) : IPresenter<T> {

    var mRootView: T? = null
        private set

    private val isViewAttached: Boolean
        get() = mRootView != null

    override fun attachView(view: T) {
        mRootView = view
    }

    init {
        mRootView = mView
    }

    override fun detachView() {
        mRootView = null
    }

//    /***
//     * get方式
//     */
//    fun <T> getHttpData(url: String, params: Map<String, String>, callback: ACallback<ResponseResult<T>>): DisposableObserver<*>? {
//        return AppHttpClient.getInstance().getDataDefault(url, params, callback)
//    }
//
//    /***
//     * post方式
//     */
//    fun <T> postHttpdata(url: String, params: Map<String, String>, callback: ACallback<ResponseResult<T>>): DisposableObserver<*>? {
//        return AppHttpClient.getInstance().postDataDefault(url, params, callback)
//    }
//
//    /***
//     * post方式
//     */
//    fun <T> postHttpdataNewAddTuiXiuRequestFrom(url: String, params: Map<String, String>, callback: ACallback<ResponseResult<T>>): DisposableObserver<*>? {
//        return AppHttpClient.getInstance().postDataDefaultNew(url, params, callback)
//    }
//
//
//    /**
//     * 上传图片
//     */
//    fun <T> uploadImg(url: String, params: Map<String, String>, callback: ACallback<T>): DisposableObserver<*>? {
//        return AppHttpClient.getInstance().uploadImg(url, params, callback)
//    }


    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    private class MvpViewNotAttachedException internal constructor() :
            RuntimeException("请在使用presenter实例之前attachView")

}