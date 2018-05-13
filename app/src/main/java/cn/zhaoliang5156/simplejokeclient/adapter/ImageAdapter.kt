package cn.zhaoliang5156.simplejokeclient.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cn.zhaoliang5156.simplejokeclient.R
import cn.zhaoliang5156.simplejokeclient.common.inflate
import cn.zhaoliang5156.simplejokeclient.net.ImageJoke
import kotlinx.android.synthetic.main.image_item.view.*

/**
 * Created by zhaoliang on 2018/5/14.
 */
class ImageAdapter(var imageJokes: ArrayList<ImageJoke>) : RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    override fun getItemCount(): Int {
        return imageJokes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(parent.inflate(R.layout.image_item))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageJokes[position])
    }

    class ImageHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ImageJoke) {
            itemView.image_title.text = item.title
            itemView.image_source.setImageURI(item.sourceurl)
        }
    }
}