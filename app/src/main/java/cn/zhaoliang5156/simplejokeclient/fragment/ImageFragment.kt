package cn.zhaoliang5156.simplejokeclient.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.zhaoliang5156.simplejokeclient.R
import cn.zhaoliang5156.simplejokeclient.adapter.ImageAdapter
import cn.zhaoliang5156.simplejokeclient.net.ImageResponse
import cn.zhaoliang5156.simplejokeclient.net.JokeService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_image.*


/**
 * A simple [Fragment] subclass.
 */
class ImageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onResume() {
        super.onResume()

        image_list.layoutManager = LinearLayoutManager(context)

        JokeService().createJokeClient()
                .loadImageJoke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ t: ImageResponse? ->
                    t?.let {
                        image_list.adapter = ImageAdapter(t.showapi_res_body.list)
                    }
                })

        // image.text = "Hello Image"
    }

}// Required empty public constructor
