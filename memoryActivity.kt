package org.techtown.app_project

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.LinearLayout
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import org.techtown.app_project.R
import com.bumptech.glide.Glide

class memoryActivity : AppCompatActivity() {
    var name: TextView? = null
    var place: TextView? = null
    var date: TextView? = null
    var oneline: TextView? = null
    var recomend: TextView? = null
    var feel: TextView? = null
    var img1_: ImageView? = null
    var img2_: ImageView? = null
    var img3_: ImageView? = null
    var img4_: ImageView? = null
    var img1: String? = null
    var img2: String? = null
    var img3: String? = null
    var img4: String? = null
    var onelinelay: LinearLayout? = null
    var recomendlay: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memory)
        onelinelay = findViewById(R.id.onelinelayout)
        recomendlay = findViewById(R.id.recomendlayout)
        name = findViewById(R.id.name)
        place = findViewById(R.id.place)
        date = findViewById(R.id.date)
        oneline = findViewById(R.id.oneline)
        recomend = findViewById(R.id.recomend)
        feel = findViewById(R.id.feel)
        img1_ = findViewById(R.id.img1)
        img2_ = findViewById(R.id.img2)
        img3_ = findViewById(R.id.img3)
        img4_ = findViewById(R.id.img4)
        img1 = intent.getStringExtra("img1").toString()
        img2 = intent.getStringExtra("img2").toString()
        img3 = intent.getStringExtra("img3").toString()
        img4 = intent.getStringExtra("img4").toString()
    }

    override fun onResume() {
        super.onResume()
        if (img2 == "null") {
            Glide.with(applicationContext).load(Uri.parse(img1)).into(img1_!!)
            img1_!!.visibility = View.VISIBLE
            img2_!!.visibility = View.GONE
            img3_!!.visibility = View.GONE
            img4_!!.visibility = View.GONE
        } else if (img3 == "null") {
            Glide.with(applicationContext).load(Uri.parse(img1)).into(img1_!!)
            Glide.with(applicationContext).load(Uri.parse(img2)).into(img2_!!)
            img1_!!.visibility = View.VISIBLE
            img2_!!.visibility = View.VISIBLE
            img3_!!.visibility = View.GONE
            img4_!!.visibility = View.GONE
        } else if (img4 == "null") {
            Glide.with(applicationContext).load(Uri.parse(img1)).error(R.drawable.d1).into(
                img1_!!
            )
            Glide.with(applicationContext).load(Uri.parse(img2)).error(R.drawable.d1).into(
                img2_!!
            )
            Glide.with(applicationContext).load(Uri.parse(img3)).error(R.drawable.d1).into(
                img3_!!
            )
            img1_!!.visibility = View.VISIBLE
            img2_!!.visibility = View.VISIBLE
            img3_!!.visibility = View.VISIBLE
            img4_!!.visibility = View.GONE
        } else {
            img1_!!.visibility = View.VISIBLE
            img2_!!.visibility = View.VISIBLE
            img3_!!.visibility = View.VISIBLE
            img4_!!.visibility = View.VISIBLE
            Glide.with(applicationContext).load(Uri.parse(img1)).error(R.drawable.d1).into(
                img1_!!
            )
            Glide.with(applicationContext).load(Uri.parse(img2)).error(R.drawable.d1).into(
                img2_!!
            )
            Glide.with(applicationContext).load(Uri.parse(img3)).error(R.drawable.d1).into(
                img3_!!
            )
            Glide.with(applicationContext).load(Uri.parse(img4)).error(R.drawable.d1).into(
                img4_!!
            )
        }
        if (intent.getStringExtra("oneline") == "null") {
            name!!.text = intent.getStringExtra("name")
            place!!.text = intent.getStringExtra("location") + intent.getStringExtra("location2")
            date!!.text = intent.getStringExtra("date")
            onelinelay!!.visibility = View.GONE
            recomendlay!!.visibility = View.GONE
            feel!!.text = intent.getStringExtra("feel")
        } else {
            name!!.text = intent.getStringExtra("name")
            place!!.text =
                intent.getStringExtra("location") + " " + intent.getStringExtra("location2")
            date!!.text = intent.getStringExtra("date")
            onelinelay!!.visibility = View.VISIBLE
            oneline!!.text = intent.getStringExtra("oneline")
            recomendlay!!.visibility = View.VISIBLE
            recomend!!.text = intent.getStringExtra("recomend")
            feel!!.text = intent.getStringExtra("feel")
        }
    }
}