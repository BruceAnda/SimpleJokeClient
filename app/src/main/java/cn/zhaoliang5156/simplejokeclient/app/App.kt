package cn.zhaoliang5156.simplejokeclient.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by zhaoliang on 2018/5/13.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}