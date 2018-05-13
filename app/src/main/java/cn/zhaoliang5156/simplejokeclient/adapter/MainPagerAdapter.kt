package cn.zhaoliang5156.simplejokeclient.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by zhaoliang on 2018/5/14.
 */
class MainPagerAdapter(var titles: ArrayList<String>, var pagers: ArrayList<Fragment>, fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return pagers[position]
    }

    override fun getCount(): Int {
        return pagers.size
    }

    // 获取页卡标题
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}