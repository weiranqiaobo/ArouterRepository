package com.test.base.basecomponent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.view.View
import android.widget.TextView
import com.test.base.R

/**
 *@Date 2018/5/18
 *@Author Mr.WEI
 *@Description BaseActivity
 **/
abstract class KotlinBaseActivity : AppCompatActivity() {
    protected var mActivity: Activity? = null
    protected var screenWidth: Int = 0
    protected var screenHeight: Int = 0
    private var basePresenter: IPresenter<*>? = null
    //返回键是否可用
    private var isNeedAutoBackView = true
    protected var isUseAnima = true

    companion object {
//        val lifecycleSubject: PublishSubject<ActivityLifeCycleEvent> = PublishSubject.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isUseAnima) {
//            overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim)
        }
        setContentView(getRootResId())
        mActivity = this
        screenWidth = resources.displayMetrics.widthPixels
        screenHeight = resources.displayMetrics.heightPixels
        initOthers()
        initData()
        initView()
        startNet()
        initListener()
        tryToAddBackClick()
    }


    override fun onResume() {
        super.onResume()
//        lifecycleSubject.onNext(ActivityLifeCycleEvent.RESUME)
    }


    /**
     * 设置toolbar中间的textView
     */
    protected fun setTitleMiddleText(text: String) {
        setTitleMiddleText(View.VISIBLE, text)
    }

    /**
     *   设置toolbar中间的textView
     */
    fun setTitleMiddleText(visibility: Int, text: String) {
        val view = findViewById<TextView>(R.id.text_toolbar_middle)
        view.visibility = visibility
        view.text = text
    }

    /**
     * 设置是否需要默认返回
     */
    fun setNeedAutoBackView(isNeedAutoBackView: Boolean) {
        this.isNeedAutoBackView = isNeedAutoBackView
    }


    /**
     * 返回键的默认点击销毁当前activity
     */
    private fun tryToAddBackClick() {
        val backView = findViewById<AppCompatImageView>(R.id.image_toolbar_back)
        if (isNeedAutoBackView && backView != null) {
            backView.setOnClickListener {
                backClickTask()
                finish()
            }
        }
    }


    /**
     * 点击左上角返回按钮需要执行的操作
     */
    open fun backClickTask() {

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

    override fun finish() {
        super.finish()
        if (isUseAnima) {
//            overridePendingTransition(R.anim.close_enter_anim, R.anim.close_exit_anim)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (getPresenter() is IPresenter<*>) {
            basePresenter = getPresenter() as IPresenter<*>?
            basePresenter?.detachView()
        }
//        lifecycleSubject.onNext(ActivityLifeCycleEvent.DESTROY)
//        RxBusManager.dispose(getBusTag())
    }

    open fun getBusTag(): String? = null
    abstract fun initOthers()
    abstract fun getPresenter(): Any?
    abstract fun getRootResId(): Int
    abstract fun initData()
    abstract fun initView()
    abstract fun startNet()
    abstract fun initListener()
}