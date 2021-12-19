package org.techtown.app_project

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.techtown.app_project.R
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import java.lang.Exception
import java.util.HashMap

class ResisterActivity() : AppCompatActivity() {
    var name: EditText? = null
    var age: EditText? = null
    var id: EditText? = null
    var pw: EditText? = null
    var check: EditText? = null
    var db: FirebaseFirestore? = null
    var ok: Button? = null
    var button_cancel: Button? = null
    var idcheck = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resister)
        name = findViewById(R.id.et_name)
        id = findViewById(R.id.et_ID)
        age = findViewById(R.id.et_age)
        pw = findViewById(R.id.et_Pwd)
        check = findViewById(R.id.et_Pwd_Check)
        button_cancel = findViewById(R.id.button_cancel)
        button_cancel?.setOnClickListener(View.OnClickListener { finish() })
        db = FirebaseFirestore.getInstance()
        ok = findViewById(R.id.button_ok)
        ok?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                if ((name?.getText().toString() === "") || (id?.getText()
                        .toString() == "") || (age?.getText().toString() == "") || (pw?.getText()
                        .toString() == "") || (check?.getText().toString() == "")
                ) {
                    Toast.makeText(applicationContext, "가입정보를 올바르게 기입해주세요.", Toast.LENGTH_SHORT)
                        .show()
                } else if (pw?.getText().toString() != check?.getText().toString()) {
                    Toast.makeText(applicationContext, "비밀번호을 확인해주세요.", Toast.LENGTH_SHORT).show()
                } else {
                    db!!.collection("users")
                        .get()
                        .addOnCompleteListener(object : OnCompleteListener<QuerySnapshot> {
                            override fun onComplete(task: Task<QuerySnapshot>) {
                                if (task.isSuccessful) {
                                    for (document: QueryDocumentSnapshot in task.result!!) {
                                        if ((document.getString("id") == id?.getText().toString())) {
                                            idcheck = 1
                                            break
                                        }
                                    }
                                    if (idcheck == 1) {
                                        Toast.makeText(
                                            applicationContext,
                                            "아이디가 중복됩니다.",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        idcheck = 0
                                    } else {
                                        val map = HashMap<String, Any>()
                                        map["name"] = name?.getText().toString()
                                        map["id"] = id?.getText().toString()
                                        map["age"] = age?.getText().toString()
                                        map["pw"] = pw?.getText().toString()
                                        db!!.collection("users").document(id?.getText().toString())
                                            .set(map).addOnCompleteListener(
                                            OnCompleteListener {
                                                Toast.makeText(
                                                    applicationContext,
                                                    "가입이 완료되었습니다.",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                                finish()
                                            }).addOnFailureListener(object : OnFailureListener {
                                            override fun onFailure(e: Exception) {}
                                        })
                                    }
                                }
                            }
                        })
                }
            }
        })
    }
}