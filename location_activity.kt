package org.techtown.app_project

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import org.techtown.app_project.R
import android.content.Intent
import android.view.View
import android.view.Window
import android.widget.ImageView

class location_activity : AppCompatActivity() {
    var cities = arrayOf(
        "경상남도",
        "경상북도",
        "충청북도",
        "강원도",
        "경기도",
        "전라남도",
        "전라북도",
        "충청남도",
        "서울특별시",
        "대구",
        "부산광역시",
        "대전광역시",
        "광주광역시",
        "울산광역시",
        "인천광역시",
        "제주특별자치도"
    )
    var badge: ImageView? = null
    var t1: TextView? = null
    var t2: TextView? = null
    var t3: TextView? = null
    var t4: TextView? = null
    var t5: TextView? = null
    var t6: TextView? = null
    var t7: TextView? = null
    var t8: TextView? = null
    var t9: TextView? = null
    var t10: TextView? = null
    var t11: TextView? = null
    var t12: TextView? = null
    var t13: TextView? = null
    var t14: TextView? = null
    var t15: TextView? = null
    var t16: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_location)
        t1 = findViewById(R.id.t1)
        t1?.setText(cities[0])
        t2 = findViewById(R.id.t2)
        t2?.setText(cities[1])
        t3 = findViewById(R.id.t3)
        t3?.setText(cities[2])
        t4 = findViewById(R.id.t4)
        t4?.setText(cities[3])
        t5 = findViewById(R.id.t5)
        t5?.setText(cities[4])
        t6 = findViewById(R.id.t6)
        t6?.setText(cities[5])
        t7 = findViewById(R.id.t7)
        t7?.setText(cities[6])
        t8 = findViewById(R.id.t8)
        t8?.setText(cities[7])
        t9 = findViewById(R.id.t9)
        t9?.setText(cities[8])
        t10 = findViewById(R.id.t10)
        t10?.setText(cities[9])
        t11 = findViewById(R.id.t11)
        t11?.setText(cities[10])
        t12 = findViewById(R.id.t12)
        t12?.setText(cities[11])
        t13 = findViewById(R.id.t13)
        t13?.setText(cities[12])
        t14 = findViewById(R.id.t14)
        t14?.setText(cities[13])
        t15 = findViewById(R.id.t15)
        t15?.setText(cities[14])
        t16 = findViewById(R.id.t16)
        t16?.setText(cities[15])
        t1?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t1?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t2?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t2?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t3?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t3?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t4?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t4?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t5?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t5?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t6?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t6?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t7?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t7?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t8?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t8?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t9?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t9?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t10?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t10?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t11?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t11?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t12?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t12?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t13?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t13?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t14?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t14?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t15?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t15?.getText().toString())
            setResult(0, ti)
            finish()
        })
        t16?.setOnClickListener(View.OnClickListener {
            val ti = Intent()
            ti.putExtra("place", t16?.getText().toString())
            setResult(0, ti)
            finish()
        })
    }
}