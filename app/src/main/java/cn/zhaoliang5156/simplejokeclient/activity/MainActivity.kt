package cn.zhaoliang5156.simplejokeclient.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.util.Log
import cn.zhaoliang5156.simplejokeclient.R
import cn.zhaoliang5156.simplejokeclient.adapter.MainPagerAdapter
import cn.zhaoliang5156.simplejokeclient.fragment.ImageFragment
import cn.zhaoliang5156.simplejokeclient.fragment.TextFragment
import cn.zhaoliang5156.simplejokeclient.net.JokeService
import cn.zhaoliang5156.simplejokeclient.net.TextResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 主界面
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建标题集合
        var titles = ArrayList<String>()
        // 把标题添加到集合中
        titles.add("段子")
        titles.add("图片")

        // 创建页面的集合
        var pagers = ArrayList<Fragment>()
        // 把页面放到集合中
        pagers.add(TextFragment())
        pagers.add(ImageFragment())
        // 设置页面适配器
        main_pager.adapter = MainPagerAdapter(titles, pagers, supportFragmentManager)

        // 把TableLayout和viewPager关联起来
        main_tabs.setupWithViewPager(main_pager)

        // 请求网络数据
        JokeService()
                .createJokeClient()
                .loadTextJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: TextResponse? ->
                    t?.let {
                        Log.i("Hello", "$t.showapi_res_body.list.size")
                    }
                })
    }
}
