package org.techtown.app_project

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import android.widget.EditText
import android.os.Bundle
import org.techtown.app_project.R
import com.bumptech.glide.Glide
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import org.techtown.app_project.ResisterActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.DocumentSnapshot
import org.techtown.app_project.MainActivity
import android.widget.Toast

class StartActivity : AppCompatActivity() {
    var login: Button? = null
    var register: Button? = null
    var button_login: Button? = null

    var db: FirebaseFirestore? = null
    var id: EditText? = null
    var pw: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var image: ImageView =findViewById(R.id.image)
        id = findViewById(R.id.et_ID_login)
        pw = findViewById(R.id.et_pwd_login)
        Glide.with(this).load(R.raw.img).centerCrop().into(image)
        db = FirebaseFirestore.getInstance()
        login = findViewById(R.id.button_login)
        register = findViewById(R.id.button_register)
        button_login = findViewById(R.id.button_login)
        register?.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext, ResisterActivity::class.java
                )
            )
        })
        button_login?.setOnClickListener(View.OnClickListener {
            db!!.collection("users")
                .whereEqualTo("id", id?.getText().toString())
                .whereEqualTo("pw", pw?.getText().toString())
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful && task.result != null && task.result!!
                            .documents.size > 0
                    ) {
                        val my = task.result!!.documents[0]
                        val intent = Intent(applicationContext, MainActivity::class.java)
                        intent.putExtra("id", my.getString("id"))
                        intent.putExtra("name", my.getString("name"))
                        startActivity(intent)
                        Toast.makeText(
                            applicationContext,
                            my.getString("name") + "님 환영합니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(applicationContext, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
        })
    }
}