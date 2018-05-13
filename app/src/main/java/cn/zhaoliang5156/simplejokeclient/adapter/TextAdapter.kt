package cn.zhaoliang5156.simplejokeclient.adapter

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.view.ViewGroup
import cn.zhaoliang5156.simplejokeclient.R
import cn.zhaoliang5156.simplejokeclient.common.inflate
import cn.zhaoliang5156.simplejokeclient.net.TextJoke
import kotlinx.android.synthetic.main.text_item.view.*

/**
 * Created by zhaoliang on 2018/5/14.
 */
class TextAdapter(var items: ArrayList<TextJoke>) : RecyclerView.Adapter<TextAdapter.TextHolder>() {

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextHolder {
        return TextHolder(parent.inflate(R.layout.text_item))
    }

    class TextHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: TextJoke) {
            itemView.title.text = Html.fromHtml(item.title)
            itemView.content.text = Html.fromHtml(item.content)
        }
    }
}