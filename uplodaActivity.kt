package org.techtown.app_project

import android.Manifest
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import android.os.Bundle
import org.techtown.app_project.R
import android.content.Intent
import org.techtown.app_project.location_activity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import android.provider.MediaStore
import android.app.Activity
import android.content.pm.PackageManager
import android.net.Uri
import android.view.ViewGroup
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class uplodaActivity : AppCompatActivity() {
    private var photoUri: Uri? = null
    private var photoUri2: Uri? = null
    private var photoUri3: Uri? = null
    private var photoUri4: Uri? = null
    var swit: Switch? = null
    var num: Int? = null
    var oneline: LinearLayout? = null
    var recomendlayout: LinearLayout? = null
    var feel1: EditText? = null
    var recomend: EditText? = null
    var second: RelativeLayout? = null
    var third: RelativeLayout? = null
    var fourth: RelativeLayout? = null
    var upload: Button? = null
    var cancle: Button? = null
    var secret: EditText? = null
    var location: TextView? = null
    var location2: EditText? = null
    var date: EditText? = null
    var feel: EditText? = null
    var db: FirebaseFirestore? = null
    var imageview_picture: ImageView? = null
    var imageview_picture2: ImageView? = null
    var imageview_picture3: ImageView? = null
    var imageview_picture4: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        val MY_PERMISSIONS_REQUEST_CAMERA = 0
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST_CAMERA
            )
        }
        db = FirebaseFirestore.getInstance()

        db!!.collection("travles")
            .whereEqualTo("id", intent.getStringExtra("id"))
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    num = task.result!!.size()
                }
            }

        feel1 = findViewById(R.id.feel)
        swit = findViewById<Switch>(R.id.swit)
        secret = findViewById(R.id.secret)
        swit?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { compoundButton, b ->
            if (b) {
                oneline!!.visibility = View.VISIBLE
                recomendlayout!!.visibility = View.VISIBLE
                feel!!.hint = "더 들려주고 싶은 이야기를 적어주세요."
                secret?.hint="전체공개"
            } else {
                oneline!!.visibility = View.GONE
                recomendlayout!!.visibility = View.GONE
                feel!!.hint = "이번 여행은 어땟나요 ?"
                secret!!.hint = "비밀글"
            }
        })
        recomend = findViewById(R.id.recomend)

        oneline = findViewById(R.id.oneline)
        recomendlayout = findViewById(R.id.recomendlayout)
        location = findViewById(R.id.edittext_input_location)
        location?.setOnClickListener(View.OnClickListener {
            startActivityForResult(
                Intent(
                    applicationContext,
                    location_activity::class.java
                ), 0
            )
        })
        upload = findViewById(R.id.button_upload)
        location2 = findViewById(R.id.edittext_input_location2)
        date = findViewById(R.id.edittext_input_date)
        feel = findViewById(R.id.edittext_input_feel)
        cancle = findViewById(R.id.button_cancle)
        upload?.setOnClickListener(View.OnClickListener {
            if (swit?.isChecked == true)  {
                val map = HashMap<String, Any?>()
                map["id"] = intent.getStringExtra("id")
                map["num"] = (num?.plus(1)).toString()
                map["name"] = intent.getStringExtra("name")
                map["location"] = location?.getText().toString()
                map["location2"] = location2?.getText().toString()
                map["date"] = date?.getText().toString()
                map["oneline"] = feel1?.getText().toString()
                map["recomend"] = recomend?.getText().toString()
                map["feel"] = feel?.getText().toString()
                if (photoUri == null) {
                    map["img1"] = "null"
                } else {
                    map["img1"] = photoUri.toString()
                }
                if (photoUri2 == null) {
                    map["img2"] = "null"
                } else {
                    map["img2"] = photoUri2.toString()
                }
                if (photoUri3 == null) {
                    map["img3"] = "null"
                } else {
                    map["img3"] = photoUri3.toString()
                }
                if (photoUri4 == null) {
                    map["img4"] = "null"
                } else {
                    map["img4"] = photoUri4.toString()
                }
                db!!.collection("travles").add(map).addOnCompleteListener {
                    Toast.makeText(applicationContext, "업로드 성공하였습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(
                        applicationContext,
                        "다시 시도해주세요.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                val map = HashMap<String, Any?>()
                map["id"] = intent.getStringExtra("id")
                map["num"] = (num?.plus(1)).toString()
                map["location"] = location?.getText().toString()
                map["location2"] = location2?.getText().toString()
                map["date"] = date?.getText().toString()
                map["feel"] = feel?.getText().toString()
                map["name"] = intent.getStringExtra("name")
                map["oneline"] = "null"
                map["recomend"] = "null"
                if (photoUri == null) {
                    map["img1"] = "null"
                } else {
                    map["img1"] = photoUri.toString()
                }
                if (photoUri2 == null) {
                    map["img2"] = "null"
                } else {
                    map["img2"] = photoUri2.toString()
                }
                if (photoUri3 == null) {
                    map["img3"] = "null"
                } else {
                    map["img3"] = photoUri3.toString()
                }
                if (photoUri4 == null) {
                    map["img4"] = "null"
                } else {
                    map["img4"] = photoUri4.toString()
                }
                db!!.collection("travles").add(map).addOnCompleteListener {
                    Toast.makeText(applicationContext, "업로드 성공하였습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(
                        applicationContext,
                        "다시 시도해주세요.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
        cancle?.setOnClickListener(View.OnClickListener { finish() })
        second = findViewById(R.id.second)
        third = findViewById(R.id.third)
        fourth = findViewById(R.id.fourth)
        imageview_picture = findViewById(R.id.imageview_picture)
        imageview_picture2 = findViewById(R.id.imageview_picture2)
        imageview_picture3 = findViewById(R.id.imageview_picture3)
        imageview_picture4 = findViewById(R.id.imageview_picture4)
        imageview_picture2?.setOnClickListener(View.OnClickListener { })
        imageview_picture?.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 10012)


        })
        imageview_picture2?.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 10013)
        })
        imageview_picture3?.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 10014)
        })
        imageview_picture4?.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 10015)
        })
    }

    @SuppressLint("Range")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //이미지 뷰를 클릭하면 시작되는 함수
        if (requestCode == 10012 && resultCode == RESULT_OK && data != null) {
            //response에 getData , return data 부분 추가해주어야 한다




//            //response에 getData , return data 부분 추가해주어야 한다
//            val proj = arrayOf(MediaStore.Images.Media.DATA)
//            val cursor = contentResolver.query(data.data!!, proj, null, null, null)
//            cursor!!.moveToNext()
//            val path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA))
//            val uri = Uri.fromFile(File(path))
//
//            cursor.close()
            photoUri = data.data!!
            uploadImageTOFirebase(photoUri!!,1)

            val params = imageview_picture!!.layoutParams
            params.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            params.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            Glide.with(applicationContext).load(photoUri).into(imageview_picture!!)
            second!!.visibility = View.VISIBLE
        } else if (requestCode == 10013 && resultCode == RESULT_OK && data != null) {
            photoUri2 = data.data!!
            uploadImageTOFirebase(photoUri2!!,2)


            val params = imageview_picture2!!.layoutParams
            params.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            params.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            Glide.with(applicationContext).load(photoUri2).into(imageview_picture2!!)
            third!!.visibility = View.VISIBLE
        } else if (requestCode == 10014 && resultCode == RESULT_OK && data != null) {

            photoUri3 = data.data!!
            uploadImageTOFirebase(photoUri3!!,3)

            val params = imageview_picture3!!.layoutParams
            params.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            params.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            Glide.with(applicationContext).load(photoUri3).into(imageview_picture3!!)
            fourth!!.visibility = View.VISIBLE
        } else if (requestCode == 10015 && resultCode == RESULT_OK && data != null) {
            photoUri4 = data.data!!
            uploadImageTOFirebase(photoUri4!!,4)
            val params = imageview_picture4!!.layoutParams
            params.width = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            params.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                130f,
                resources.displayMetrics
            )
                .toInt()
            Glide.with(applicationContext).load(photoUri4).into(imageview_picture4!!)
        } else if (requestCode == 0) {
            location!!.text = data!!.getStringExtra("place")
        }
    }

    fun uploadImageTOFirebase(uri: Uri,i:Int) {
        var storage: FirebaseStorage? = FirebaseStorage.getInstance()   //FirebaseStorage 인스턴스 생성
        //파일 이름 생성.
        var fileName = intent.getStringExtra("name")+(num?.plus(1))+"-"+i+".png"
        //파일 업로드, 다운로드, 삭제, 메타데이터 가져오기 또는 업데이트를 하기 위해 참조를 생성.
        //참조는 클라우드 파일을 가리키는 포인터라고 할 수 있음.
        var imagesRef = storage!!.reference.child("images/").child(fileName)    //기본 참조 위치/images/${fileName}
        //이미지 파일 업로드
        imagesRef.putFile(uri!!).addOnSuccessListener {

        }
    }
}

