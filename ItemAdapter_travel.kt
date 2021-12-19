package org.techtown.app_project

import androidx.recyclerview.widget.RecyclerView
import org.techtown.app_project.Travel
import android.view.ViewGroup
import android.view.LayoutInflater
import org.techtown.app_project.R
import android.annotation.SuppressLint
import android.widget.TextView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import android.content.Intent
import android.net.Uri
import android.view.View
import org.techtown.app_project.memoryActivity
import java.util.ArrayList

class ItemAdapter_travel : RecyclerView.Adapter<ItemAdapter_travel.ViewHolder>() {
    var travels = ArrayList<Travel>()
    fun addItem(item: Travel) {
        travels.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.itemadapter_2, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.setItem(travels[position])
    }

    override fun getItemCount(): Int {
        return travels.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview_name: TextView
        var date: TextView
        var img1: RoundedImageView
        var img2: RoundedImageView
        var img3: RoundedImageView
        var img4: RoundedImageView
        fun setItem(travel: Travel) {


//            img1.setBackground(new ShapeDrawable(new OvalShape()));
//            img1.setClipToOutline(true);
//            img2.setBackground(new ShapeDrawable(new OvalShape()));
//            img2.setClipToOutline(true);
//            img3.setBackground(new ShapeDrawable(new OvalShape()));
//            img3.setClipToOutline(true);
//            img4.setBackground(new ShapeDrawable(new OvalShape()));
//            img4.setClipToOutline(true);
            textview_name.text = travel.location
            date.text = travel.date
            if (travel.img2 == "null") {
                Glide.with(itemView).load(Uri.parse(travel.img1)).into(img1)
                img2.setImageBitmap(null)
                img3.setImageBitmap(null)
                img4.setImageBitmap(null)
            } else if (travel.img3 == "null") {
                Glide.with(itemView).load(Uri.parse(travel.img1)).into(img1)
                Glide.with(itemView).load(Uri.parse(travel.img2)).into(img2)
                img3.setImageBitmap(null)
                img4.setImageBitmap(null)
            } else if (travel.img4 == "null") {
                Glide.with(itemView).load(Uri.parse(travel.img1)).into(img1)
                Glide.with(itemView).load(Uri.parse(travel.img2)).into(img2)
                Glide.with(itemView).load(Uri.parse(travel.img3)).into(img3)
                img4.setImageBitmap(null)
            } else {
                Glide.with(itemView).load(Uri.parse(travel.img1)).into(img1)
                Glide.with(itemView).load(Uri.parse(travel.img2)).into(img2)
                Glide.with(itemView).load(Uri.parse(travel.img3)).into(img3)
                Glide.with(itemView).load(Uri.parse(travel.img4)).into(img4)
            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, memoryActivity::class.java)
                intent.putExtra("name", travel.name)
                intent.putExtra("location", travel.location)
                intent.putExtra("location2", travel.location2)
                intent.putExtra("date", travel.date)
                intent.putExtra("img1", travel.img1)
                intent.putExtra("img2", travel.img2)
                intent.putExtra("img3", travel.img3)
                intent.putExtra("img4", travel.img4)
                intent.putExtra("oneline", travel.oneline)
                intent.putExtra("recomend", travel.recomend)
                intent.putExtra("feel", travel.feel)
                itemView.context.startActivity(intent)
            }
        }

        init {
            date = itemView.findViewById(R.id.date)
            textview_name = itemView.findViewById(R.id.textview_name)
            img1 = itemView.findViewById(R.id.imageview_1)
            img2 = itemView.findViewById(R.id.imageview_2)
            img3 = itemView.findViewById(R.id.imageview_3)
            img4 = itemView.findViewById(R.id.imageview_4)
        }
    }
}