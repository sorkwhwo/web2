package org.techtown.app_project

import com.google.firebase.firestore.FirebaseFirestore
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

class searchfragment : Fragment() {
    var itemAdapter_chat: ItemAdapter_chat? = null
    var db: FirebaseFirestore? = null
    var chats: RecyclerView? = null
    var loading: ProgressBar? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_searchfragment, container, false)




        chats = rootView.findViewById(R.id.chats)
        chats?.setLayoutManager(GridLayoutManager(context, 1))
        db = FirebaseFirestore.getInstance()
        return rootView
    }

    override fun onStart() {
        super.onStart()

        itemAdapter_chat = ItemAdapter_chat()
        db!!.collection("travles")
            .whereNotEqualTo("oneline", "null")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        itemAdapter_chat!!.addItem(
                            Travel(
                                document.getString("name")!!,
                                document.getString("oneline")!!,
                                document.getString("recomend")!!,
                                document.getString("feel")!!,
                                document.getString("date")!!,
                                document.getString("location")!!,
                                document.getString("location2")!!,
                                document.getString("img1")!!,
                                document.getString("img2")!!,
                                document.getString("img3")!!,
                                document.getString("img4")!!,
                                document.getString("num")!!
                            )
                        )
                    }
                    chats!!.adapter = itemAdapter_chat

                }
            }
    }
}