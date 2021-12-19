package org.techtown.app_project

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.os.Bundle
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import org.techtown.app_project.R
import org.techtown.app_project.searchfragment
import org.techtown.app_project.homefragment
import android.content.Intent
import android.view.View
import android.widget.ImageView
import org.techtown.app_project.uplodaActivity
import org.techtown.app_project.badgeFragment

class MainActivity : AppCompatActivity() {
    var home: ImageView? = null
    var upload: ImageView? = null
    var pages: ImageView? = null
    var talk: ImageView? = null
    var backKeyPressedTime: Long = 0
    var id: String? = null
    var name: String? = null
    var toast: Toast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val MY_PERMISSIONS_REQUEST = 0
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.MANAGE_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST
            )
        }
        id = intent.getStringExtra("id")
        name = intent.getStringExtra("name")
        setContentView(R.layout.activity_main)
        home = findViewById(R.id.imageview_home)
        upload = findViewById(R.id.imageview_upload)
        pages = findViewById(R.id.imageview_badgepage)
        talk = findViewById(R.id.imageview_talk)
        talk?.setOnClickListener(View.OnClickListener {
            val searchfragment = searchfragment()
            supportFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.container, searchfragment).commit()
        })
        val homefragment = homefragment()
        supportFragmentManager.beginTransaction().addToBackStack(null)
            .replace(R.id.container, homefragment).commit()
        home?.setOnClickListener(View.OnClickListener {
            val homefragment = homefragment()
            supportFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.container, homefragment).commit()
        })
        upload?.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, uplodaActivity::class.java)
            intent.putExtra("id", id)
            intent.putExtra("name", name)
            startActivity(intent)
        })
        pages?.setOnClickListener(View.OnClickListener {
            val badgeFragment = badgeFragment()
            supportFragmentManager.beginTransaction().addToBackStack(null)
                .replace(R.id.container, badgeFragment).commit()
        })
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 1000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast = Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
            toast?.show()
            return
        } else if (System.currentTimeMillis() <= backKeyPressedTime + 1000) {
            finishAffinity()
        }
    }
}