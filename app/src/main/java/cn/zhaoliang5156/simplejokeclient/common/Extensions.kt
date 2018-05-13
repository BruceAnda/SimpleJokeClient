package cn.zhaoliang5156.simplejokeclient.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zhaoliang on 2018/5/14.
 *
 * 扩展类，用来扩展系统组件
 */
fun ViewGroup.inflate(layoutID: Int, attacheToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutID, this, attacheToRoot)
}