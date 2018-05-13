package cn.zhaoliang5156.simplejokeclient.activity.net

import cn.zhaoliang5156.simplejokeclient.activity.app.App
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoliang on 2018/5/13.
 * joke网络请求服务
 * version 1.0
 */
class JokeService {

    fun createJokeClient(): JokeClient {

        // Log
        var httpLog = HttpLoggingInterceptor()
        httpLog.level = HttpLoggingInterceptor.Level.BODY

        // ok客户端
        var okClient = OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .cache(Cache(File(App().cacheDir, "cache"), 10240))
                .addInterceptor(httpLog)
                .build()

        // 通过retrofit创建jokeClient对象
        return Retrofit.Builder()
                .client(okClient)
                .baseUrl("http://route.showapi.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeClient::class.java)
    }
}