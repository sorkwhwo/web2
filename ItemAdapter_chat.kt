package org.techtown.app_project

import androidx.recyclerview.widget.RecyclerView
import org.techtown.app_project.Travel
import android.view.ViewGroup
import android.view.LayoutInflater
import org.techtown.app_project.R
import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.CalendarContract.Attendees.query
import android.provider.CalendarContract.EventDays.query
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.loader.content.CursorLoader
import org.techtown.app_project.memoryActivity
import java.util.ArrayList
import java.util.logging.Level.parse


import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener

import com.google.firebase.storage.StorageReference

import com.google.firebase.storage.FirebaseStorage




class ItemAdapter_chat : RecyclerView.Adapter<ItemAdapter_chat.ViewHolder>() {
    var travels = ArrayList<Travel>()
    fun addItem(item: Travel) {
        travels.add(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.itemadapter_chat, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.setItem(travels[position])
    }

    override fun getItemCount(): Int {
        return travels.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView
        var img1: ImageView
        var img2: ImageView
        var img3: ImageView
        var img4: ImageView
        var name: TextView
        var place: TextView
        var oneline: TextView
        var recomend: TextView
        var feel: TextView
        lateinit var loading: ProgressBar
        var onelinelay: LinearLayout? = null
        var recomendlay: LinearLayout? = null
        @SuppressLint("Range")
        fun setItem(travel: Travel) {
            place.text = travel.location + " " + travel.location2
            date.text = travel.date
            recomend.text = travel.recomend
            oneline.text = travel.oneline
            feel.text = travel.feel
            name.text = travel.name

            loading.visibility =View.VISIBLE
            val storage = FirebaseStorage.getInstance()
            val storageReference =
                storage.getReferenceFromUrl("gs://app-project-3f6f5.appspot.com/")
            var fileName1 = travel.name+travel.num+"-"+1+".png"
            var fileName2 = travel.name+travel.num+"-"+2+".png"
            var fileName3 = travel.name+travel.num+"-"+3+".png"
            var fileName4 = travel.name+travel.num+"-"+4+".png"








            if (travel.img2 == "null") {









                val pathReference = storageReference.child("images/").child(fileName1)
                pathReference.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img1)
                    loading.visibility =View.GONE
                }.addOnFailureListener {

                }

                img1.visibility = View.VISIBLE
                img2.visibility = View.GONE
                img3.visibility = View.GONE
                img4.visibility = View.GONE

            } else if (travel.img3 == "null") {

                val pathReference = storageReference.child("images/").child(fileName1)
                pathReference.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img1)
                }.addOnFailureListener {

                }

                val pathReference2 = storageReference.child("images/").child(fileName2)
                pathReference2.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img2)
                    loading.visibility =View.GONE
                }.addOnFailureListener {

                }



                img1.visibility = View.VISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.GONE
                img4.visibility = View.GONE

            } else if (travel.img4 == "null") {
                val pathReference = storageReference.child("images/").child(fileName1)
                pathReference.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img1)
                }.addOnFailureListener {

                }

                val pathReference2 = storageReference.child("images/").child(fileName2)
                pathReference2.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img2)
                }.addOnFailureListener {

                }
                val pathReference3 = storageReference.child("images/").child(fileName2)
                pathReference3.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img3)
                    loading.visibility =View.GONE
                }.addOnFailureListener {

                }
                img1.visibility = View.VISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.VISIBLE
                img4.visibility = View.GONE

            } else {
                img1.visibility = View.VISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.VISIBLE
                img4.visibility = View.VISIBLE
                val pathReference = storageReference.child("images/").child(fileName1)
                pathReference.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img1)
                }.addOnFailureListener {

                }

                val pathReference2 = storageReference.child("images/").child(fileName2)
                pathReference2.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img2)
                }.addOnFailureListener {

                }
                val pathReference3 = storageReference.child("images/").child(fileName3)
                pathReference3.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img3)
                }.addOnFailureListener {

                }
                val pathReference4 = storageReference.child("images/").child(fileName4)
                pathReference4.downloadUrl.addOnSuccessListener { uri ->
                    Glide.with(itemView.context).load(uri).into(img4)
                    loading.visibility =View.GONE
                }.addOnFailureListener {

                }

            }
        }

        init {
            name = itemView.findViewById(R.id.name)
            place = itemView.findViewById(R.id.place)
            oneline = itemView.findViewById(R.id.oneline)
            recomend = itemView.findViewById(R.id.recomend)
            feel = itemView.findViewById(R.id.feel)
            date = itemView.findViewById(R.id.date)
            img1 = itemView.findViewById(R.id.img1)
            img2 = itemView.findViewById(R.id.img2)
            img3 = itemView.findViewById(R.id.img3)
            img4 = itemView.findViewById(R.id.img4)
            loading = itemView.findViewById(R.id.loading)
        }
    }
}