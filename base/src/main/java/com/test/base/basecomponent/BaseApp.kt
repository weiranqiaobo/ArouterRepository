package com.test.base.basecomponent

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 *@Date 2018/7/9
 *@Author Mr.WEI
 *@Description
 **/
open class BaseApp : Application() {
    companion object {
        var mBiHuApplication: BaseApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        mBiHuApplication = this
        initRouter(this)
    }

    private fun initRouter(mApplication: BaseApp) {
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
//        if (UIUtils.isApkInDebug(instance)) {
//            //打印日志
        ARouter.openLog()
        //开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
        //线上版本需要关闭,否则有安全风险)
        ARouter.openDebug()
//        }

        // 尽可能早，推荐在Application中初始化
        ARouter.init(mApplication)

    }
}