package com.test.base.basecomponent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 *@Date 2018/5/19
 *@Author Mr.WEI
 *@Description BaseFragment
 **/
abstract class KotlinBaseFragment : Fragment() {
    protected var mActivity: Activity? = null
    protected var screenWidth: Int = 0
    protected var screenHeight: Int = 0
    protected var mThis: KotlinBaseFragment? = null
    private var basePresenter: IPresenter<*>? = null
    protected var mRootView: View? = null

    /**
     * 视图是否加载完毕
     */
    private var isViewPrepare = false
    /**
     * 数据是否加载过了
     */
    private var hasLoadData = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(getLayoutId(), null)
        return mRootView
    }



    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            lazyLoadDataIfPrepare()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity
        mThis = this
        screenWidth = resources.displayMetrics.widthPixels
        screenHeight = resources.displayMetrics.heightPixels
        isViewPrepare = true
        initOthers()
        initView()
        lazyLoadDataIfPrepare()
    }

    abstract fun initOthers()


    private fun lazyLoadDataIfPrepare() {
        if (userVisibleHint && isViewPrepare && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        }
    }

    /**
     * @param clazz   目标类
     * @param bundle  参数
     * @param code requestId
     */
    protected fun toOtherBackActivity(clazz: Class<*>, bundle: Bundle?, code: Int) {
        val intent = Intent(mActivity, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mActivity?.startActivityForResult(intent, code)
    }

    /**
     * @param clazz   目标类
     * @param bundle  参数
     */
    protected fun toOtherActivity(clazz: Class<*>, bundle: Bundle?) {
        val intent = Intent(mActivity, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        mActivity?.startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (getPresenter() is IPresenter<*>) {
            basePresenter = getPresenter() as IPresenter<*>?
            basePresenter?.detachView()
        }
//        RxBusManager.dispose(getBusTag())
    }

    open fun getBusTag(): String? = null
    abstract fun getPresenter(): Any?
    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun lazyLoad()

}