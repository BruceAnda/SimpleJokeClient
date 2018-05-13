package cn.zhaoliang5156.simplejokeclient.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cn.zhaoliang5156.simplejokeclient.R
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

        text.text = "Hello Text"
    }

}// Required empty public constructor
