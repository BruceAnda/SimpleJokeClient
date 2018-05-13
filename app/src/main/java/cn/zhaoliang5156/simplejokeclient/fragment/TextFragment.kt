package cn.zhaoliang5156.simplejokeclient.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.zhaoliang5156.simplejokeclient.R
import cn.zhaoliang5156.simplejokeclient.adapter.TextAdapter
import cn.zhaoliang5156.simplejokeclient.net.JokeService
import cn.zhaoliang5156.simplejokeclient.net.TextResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_text.*


/**
 * A simple [Fragment] subclass.
 */
class TextFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onResume() {
        super.onResume()
        text_list.layoutManager = LinearLayoutManager(context)

        // 请求网络数据
        JokeService()
                .createJokeClient()
                .loadTextJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: TextResponse? ->
                    t?.let {
                        text_list.adapter = TextAdapter(t.showapi_res_body.list)
                    }
                })
    }

}// Required empty public constructor
