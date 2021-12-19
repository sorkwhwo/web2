package org.techtown.app_project

import androidx.recyclerview.widget.RecyclerView
import org.techtown.app_project.Badge
import android.view.ViewGroup
import android.view.LayoutInflater
import org.techtown.app_project.R
import android.annotation.SuppressLint
import android.widget.TextView
import android.content.Intent
import android.view.View
import android.widget.ImageView
import org.techtown.app_project.Badge_small_activity
import java.util.ArrayList

class ItemAdapter_badge_big  //    UserListener userListener;
    : RecyclerView.Adapter<ItemAdapter_badge_big.ViewHolder>() {
    var badges = ArrayList<Badge>()
    var now_point: String? = null
    var sex: String? = null
    fun addItem(item: Badge) {
        badges.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.itemadapter_big, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.setItem(badges[position])
    }

    override fun getItemCount(): Int {
        return badges.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textview_percent: TextView
        var name: TextView
        var imageview_badge: ImageView
        fun setItem(badge: Badge) {
            name.text = badge.name
            textview_percent.text = badge.percent
            imageview_badge.setImageResource(badge.img)
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, Badge_small_activity::class.java)
                intent.putExtra("name", badge.name)
                intent.putExtra("percent", badge.percent)
                intent.putExtra("img", badge.img.toString())
                itemView.context.startActivity(intent)
            }
        }

        init {
            textview_percent = itemView.findViewById(R.id.textview_percent)
            imageview_badge = itemView.findViewById(R.id.imageview_badge)
            name = itemView.findViewById(R.id.textview_name)
        }
    }
}