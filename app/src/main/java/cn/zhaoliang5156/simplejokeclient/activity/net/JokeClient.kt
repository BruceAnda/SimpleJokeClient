package cn.zhaoliang5156.simplejokeclient.activity.net

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by zhaoliang on 2018/5/13.
 * joke数据请求client
 * version 1.0
 *
 * baseurl：http://route.showapi.com
 * 文本笑话api：107-32?showapi_appid=47411&showapi_sign=fff46234902f479aa89ea911b7c59b15
 * 图片笑话api：107-33?showapi_appid=47411&showapi_sign=fff46234902f479aa89ea911b7c59b15
 */
interface JokeClient {

    @GET("107-32?showapi_appid=47411&showapi_sign=fff46234902f479aa89ea911b7c59b15")
    fun loadTextJoke() : Observable<TextResponse>

    @GET("107-33?showapi_appid=47411&showapi_sign=fff46234902f479aa89ea911b7c59b15")
    fun loadImageJoke() : Observable<ImageResponse>
}