package org.techtown.app_project

import org.techtown.app_project.MainActivity
import androidx.recyclerview.widget.RecyclerView
import org.techtown.app_project.ItemAdapter_badge_big
import com.google.firebase.firestore.FirebaseFirestore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import org.techtown.app_project.R
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.QuerySnapshot
import org.techtown.app_project.Badge
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.tasks.OnFailureListener

class badgeFragment : Fragment() {
    var city: String? = null

    var badges: RecyclerView? = null
    var loading: ProgressBar? = null
    var itemAdapter_badge: ItemAdapter_badge_big? = null
    var db: FirebaseFirestore? = null
    var strings = arrayOf(
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_badge, container, false)
        badges = rootView.findViewById(R.id.badge)
        itemAdapter_badge = ItemAdapter_badge_big()
        val activity: MainActivity = getActivity() as MainActivity
        db = FirebaseFirestore.getInstance()
        badges?.setLayoutManager(GridLayoutManager(context, 2))
        loading = rootView.findViewById(R.id.loading)
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[0])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
                        itemAdapter_badge!!.addItem(Badge("", R.drawable.gungnam, strings[0]))
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.gungnam, strings[0]))
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.gungnam, strings[0]))
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.gungnam, strings[0]))
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.gungnam, strings[0]))
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.gungnam, strings[0]))
                    }
                    db!!.collection("travles")
                        .whereEqualTo("id", activity!!.id)
                        .whereEqualTo("location", strings[1])
                        .get()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                if (task.result!!.size() == 0) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                } else if (task.result!!.size() == 1) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "20%",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                } else if (task.result!!.size() == 2) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "40%",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                } else if (task.result!!.size() == 3) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "60%",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                } else if (task.result!!.size() == 4) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "80%",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                } else if (task.result!!.size() >= 5) {
                                    itemAdapter_badge!!.addItem(
                                        Badge(
                                            "성공!!",
                                            R.drawable.gungbok,
                                            strings[1]
                                        )
                                    )
                                }
                                db!!.collection("travles")
                                    .whereEqualTo("id", activity!!.id)
                                    .whereEqualTo("location", strings[2])
                                    .get()
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            if (task.result!!.size() == 0) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            } else if (task.result!!.size() == 1) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "20%",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            } else if (task.result!!.size() == 2) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "40%",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            } else if (task.result!!.size() == 3) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "60%",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            } else if (task.result!!.size() == 4) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "80%",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            } else if (task.result!!.size() >= 5) {
                                                itemAdapter_badge!!.addItem(
                                                    Badge(
                                                        "성공!!",
                                                        R.drawable.chongbok,
                                                        strings[2]
                                                    )
                                                )
                                            }
                                            db!!.collection("travles")
                                                .whereEqualTo("id", activity!!.id)
                                                .whereEqualTo("location", strings[3])
                                                .get()
                                                .addOnCompleteListener { task ->
                                                    if (task.isSuccessful) {
                                                        if (task.result!!.size() == 0) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        } else if (task.result!!.size() == 1) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "20%",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        } else if (task.result!!.size() == 2) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "40%",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        } else if (task.result!!.size() == 3) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "60%",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        } else if (task.result!!.size() == 4) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "80%",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        } else if (task.result!!.size() >= 5) {
                                                            itemAdapter_badge!!.addItem(
                                                                Badge(
                                                                    "성공!!",
                                                                    R.drawable.gangone,
                                                                    strings[3]
                                                                )
                                                            )
                                                        }
                                                        db!!.collection("travles")
                                                            .whereEqualTo("id", activity!!.id)
                                                            .whereEqualTo("location", strings[4])
                                                            .get()
                                                            .addOnCompleteListener { task ->
                                                                if (task.isSuccessful) {
                                                                    if (task.result!!.size() == 0) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    } else if (task.result!!.size() == 1) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "20%",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    } else if (task.result!!.size() == 2) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "40%",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    } else if (task.result!!.size() == 3) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "60%",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    } else if (task.result!!.size() == 4) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "80%",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    } else if (task.result!!.size() >= 5) {
                                                                        itemAdapter_badge!!.addItem(
                                                                            Badge(
                                                                                "성공!!",
                                                                                R.drawable.gunggido,
                                                                                strings[4]
                                                                            )
                                                                        )
                                                                    }
                                                                    db!!.collection("travles")
                                                                        .whereEqualTo(
                                                                            "id",
                                                                            activity!!.id
                                                                        )
                                                                        .whereEqualTo(
                                                                            "location",
                                                                            strings[5]
                                                                        )
                                                                        .get()
                                                                        .addOnCompleteListener { task ->
                                                                            if (task.isSuccessful) {
                                                                                if (task.result!!
                                                                                        .size() == 0
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                } else if (task.result!!
                                                                                        .size() == 1
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "20%",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                } else if (task.result!!
                                                                                        .size() == 2
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "40%",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                } else if (task.result!!
                                                                                        .size() == 3
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "60%",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                } else if (task.result!!
                                                                                        .size() == 4
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "80%",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                } else if (task.result!!
                                                                                        .size() >= 5
                                                                                ) {
                                                                                    itemAdapter_badge!!.addItem(
                                                                                        Badge(
                                                                                            "성공!!",
                                                                                            R.drawable.junnam,
                                                                                            strings[5]
                                                                                        )
                                                                                    )
                                                                                }
                                                                                db!!.collection("travles")
                                                                                    .whereEqualTo(
                                                                                        "id",
                                                                                        activity!!.id
                                                                                    )
                                                                                    .whereEqualTo(
                                                                                        "location",
                                                                                        strings[6]
                                                                                    )
                                                                                    .get()
                                                                                    .addOnCompleteListener { task ->
                                                                                        if (task.isSuccessful) {
                                                                                            if (task.result!!
                                                                                                    .size() == 0
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            } else if (task.result!!
                                                                                                    .size() == 1
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "20%",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            } else if (task.result!!
                                                                                                    .size() == 2
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "40%",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            } else if (task.result!!
                                                                                                    .size() == 3
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "60%",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            } else if (task.result!!
                                                                                                    .size() == 4
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "80%",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            } else if (task.result!!
                                                                                                    .size() >= 5
                                                                                            ) {
                                                                                                itemAdapter_badge!!.addItem(
                                                                                                    Badge(
                                                                                                        "성공!!",
                                                                                                        R.drawable.junbok,
                                                                                                        strings[6]
                                                                                                    )
                                                                                                )
                                                                                            }
                                                                                            db!!.collection(
                                                                                                "travles"
                                                                                            )
                                                                                                .whereEqualTo(
                                                                                                    "id",
                                                                                                    activity!!.id
                                                                                                )
                                                                                                .whereEqualTo(
                                                                                                    "location",
                                                                                                    strings[7]
                                                                                                )
                                                                                                .get()
                                                                                                .addOnCompleteListener { task ->
                                                                                                    if (task.isSuccessful) {
                                                                                                        if (task.result!!
                                                                                                                .size() == 0
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        } else if (task.result!!
                                                                                                                .size() == 1
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "20%",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        } else if (task.result!!
                                                                                                                .size() == 2
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "40%",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        } else if (task.result!!
                                                                                                                .size() == 3
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "60%",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        } else if (task.result!!
                                                                                                                .size() == 4
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "80%",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        } else if (task.result!!
                                                                                                                .size() >= 5
                                                                                                        ) {
                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                Badge(
                                                                                                                    "성공!!",
                                                                                                                    R.drawable.chungnam,
                                                                                                                    strings[7]
                                                                                                                )
                                                                                                            )
                                                                                                        }
                                                                                                        db!!.collection(
                                                                                                            "travles"
                                                                                                        )
                                                                                                            .whereEqualTo(
                                                                                                                "id",
                                                                                                                activity!!.id
                                                                                                            )
                                                                                                            .whereEqualTo(
                                                                                                                "location",
                                                                                                                strings[8]
                                                                                                            )
                                                                                                            .get()
                                                                                                            .addOnCompleteListener { task ->
                                                                                                                if (task.isSuccessful) {
                                                                                                                    if (task.result!!
                                                                                                                            .size() == 0
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    } else if (task.result!!
                                                                                                                            .size() == 1
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "20%",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    } else if (task.result!!
                                                                                                                            .size() == 2
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "40%",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    } else if (task.result!!
                                                                                                                            .size() == 3
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "60%",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    } else if (task.result!!
                                                                                                                            .size() == 4
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "80%",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    } else if (task.result!!
                                                                                                                            .size() >= 5
                                                                                                                    ) {
                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                            Badge(
                                                                                                                                "성공!!",
                                                                                                                                R.drawable.seoul,
                                                                                                                                strings[8]
                                                                                                                            )
                                                                                                                        )
                                                                                                                    }
                                                                                                                    db!!.collection(
                                                                                                                        "travles"
                                                                                                                    )
                                                                                                                        .whereEqualTo(
                                                                                                                            "id",
                                                                                                                            activity!!.id
                                                                                                                        )
                                                                                                                        .whereEqualTo(
                                                                                                                            "location",
                                                                                                                            strings[9]
                                                                                                                        )
                                                                                                                        .get()
                                                                                                                        .addOnCompleteListener { task ->
                                                                                                                            if (task.isSuccessful) {
                                                                                                                                if (task.result!!
                                                                                                                                        .size() == 0
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                } else if (task.result!!
                                                                                                                                        .size() == 1
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "20%",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                } else if (task.result!!
                                                                                                                                        .size() == 2
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "40%",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                } else if (task.result!!
                                                                                                                                        .size() == 3
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "60%",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                } else if (task.result!!
                                                                                                                                        .size() == 4
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "80%",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                } else if (task.result!!
                                                                                                                                        .size() >= 5
                                                                                                                                ) {
                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                        Badge(
                                                                                                                                            "성공!!",
                                                                                                                                            R.drawable.daegu,
                                                                                                                                            strings[9]
                                                                                                                                        )
                                                                                                                                    )
                                                                                                                                }
                                                                                                                                db!!.collection(
                                                                                                                                    "travles"
                                                                                                                                )
                                                                                                                                    .whereEqualTo(
                                                                                                                                        "id",
                                                                                                                                        activity!!.id
                                                                                                                                    )
                                                                                                                                    .whereEqualTo(
                                                                                                                                        "location",
                                                                                                                                        strings[10]
                                                                                                                                    )
                                                                                                                                    .get()
                                                                                                                                    .addOnCompleteListener { task ->
                                                                                                                                        if (task.isSuccessful) {
                                                                                                                                            if (task.result!!
                                                                                                                                                    .size() == 0
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            } else if (task.result!!
                                                                                                                                                    .size() == 1
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "20%",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            } else if (task.result!!
                                                                                                                                                    .size() == 2
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "40%",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            } else if (task.result!!
                                                                                                                                                    .size() == 3
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "60%",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            } else if (task.result!!
                                                                                                                                                    .size() == 4
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "80%",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            } else if (task.result!!
                                                                                                                                                    .size() >= 5
                                                                                                                                            ) {
                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                    Badge(
                                                                                                                                                        "성공!!",
                                                                                                                                                        R.drawable.busan,
                                                                                                                                                        strings[10]
                                                                                                                                                    )
                                                                                                                                                )
                                                                                                                                            }
                                                                                                                                            db!!.collection(
                                                                                                                                                "travles"
                                                                                                                                            )
                                                                                                                                                .whereEqualTo(
                                                                                                                                                    "id",
                                                                                                                                                    activity!!.id
                                                                                                                                                )
                                                                                                                                                .whereEqualTo(
                                                                                                                                                    "location",
                                                                                                                                                    strings[11]
                                                                                                                                                )
                                                                                                                                                .get()
                                                                                                                                                .addOnCompleteListener { task ->
                                                                                                                                                    if (task.isSuccessful) {
                                                                                                                                                        if (task.result!!
                                                                                                                                                                .size() == 0
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                .size() == 1
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "20%",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                .size() == 2
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "40%",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                .size() == 3
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "60%",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                .size() == 4
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "80%",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                .size() >= 5
                                                                                                                                                        ) {
                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                Badge(
                                                                                                                                                                    "성공!!",
                                                                                                                                                                    R.drawable.daegun,
                                                                                                                                                                    strings[11]
                                                                                                                                                                )
                                                                                                                                                            )
                                                                                                                                                        }
                                                                                                                                                        db!!.collection(
                                                                                                                                                            "travles"
                                                                                                                                                        )
                                                                                                                                                            .whereEqualTo(
                                                                                                                                                                "id",
                                                                                                                                                                activity!!.id
                                                                                                                                                            )
                                                                                                                                                            .whereEqualTo(
                                                                                                                                                                "location",
                                                                                                                                                                strings[12]
                                                                                                                                                            )
                                                                                                                                                            .get()
                                                                                                                                                            .addOnCompleteListener { task ->
                                                                                                                                                                if (task.isSuccessful) {
                                                                                                                                                                    if (task.result!!
                                                                                                                                                                            .size() == 0
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    } else if (task.result!!
                                                                                                                                                                            .size() == 1
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "20%",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    } else if (task.result!!
                                                                                                                                                                            .size() == 2
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "40%",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    } else if (task.result!!
                                                                                                                                                                            .size() == 3
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "60%",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    } else if (task.result!!
                                                                                                                                                                            .size() == 4
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "80%",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    } else if (task.result!!
                                                                                                                                                                            .size() >= 5
                                                                                                                                                                    ) {
                                                                                                                                                                        itemAdapter_badge!!.addItem(
                                                                                                                                                                            Badge(
                                                                                                                                                                                "성공!!",
                                                                                                                                                                                R.drawable.guangjo,
                                                                                                                                                                                strings[12]
                                                                                                                                                                            )
                                                                                                                                                                        )
                                                                                                                                                                    }
                                                                                                                                                                    db!!.collection(
                                                                                                                                                                        "travles"
                                                                                                                                                                    )
                                                                                                                                                                        .whereEqualTo(
                                                                                                                                                                            "id",
                                                                                                                                                                            activity!!.id
                                                                                                                                                                        )
                                                                                                                                                                        .whereEqualTo(
                                                                                                                                                                            "location",
                                                                                                                                                                            strings[13]
                                                                                                                                                                        )
                                                                                                                                                                        .get()
                                                                                                                                                                        .addOnCompleteListener { task ->
                                                                                                                                                                            if (task.isSuccessful) {
                                                                                                                                                                                if (task.result!!
                                                                                                                                                                                        .size() == 0
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                } else if (task.result!!
                                                                                                                                                                                        .size() == 1
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "20%",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                } else if (task.result!!
                                                                                                                                                                                        .size() == 2
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "40%",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                } else if (task.result!!
                                                                                                                                                                                        .size() == 3
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "60%",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                } else if (task.result!!
                                                                                                                                                                                        .size() == 4
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "80%",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                } else if (task.result!!
                                                                                                                                                                                        .size() >= 5
                                                                                                                                                                                ) {
                                                                                                                                                                                    itemAdapter_badge!!.addItem(
                                                                                                                                                                                        Badge(
                                                                                                                                                                                            "성공!!",
                                                                                                                                                                                            R.drawable.ulsan,
                                                                                                                                                                                            strings[13]
                                                                                                                                                                                        )
                                                                                                                                                                                    )
                                                                                                                                                                                }
                                                                                                                                                                                db!!.collection(
                                                                                                                                                                                    "travles"
                                                                                                                                                                                )
                                                                                                                                                                                    .whereEqualTo(
                                                                                                                                                                                        "id",
                                                                                                                                                                                        activity!!.id
                                                                                                                                                                                    )
                                                                                                                                                                                    .whereEqualTo(
                                                                                                                                                                                        "location",
                                                                                                                                                                                        strings[14]
                                                                                                                                                                                    )
                                                                                                                                                                                    .get()
                                                                                                                                                                                    .addOnCompleteListener { task ->
                                                                                                                                                                                        if (task.isSuccessful) {
                                                                                                                                                                                            if (task.result!!
                                                                                                                                                                                                    .size() == 0
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            } else if (task.result!!
                                                                                                                                                                                                    .size() == 1
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "20%",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            } else if (task.result!!
                                                                                                                                                                                                    .size() == 2
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "40%",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            } else if (task.result!!
                                                                                                                                                                                                    .size() == 3
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "60%",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            } else if (task.result!!
                                                                                                                                                                                                    .size() == 4
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "80%",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            } else if (task.result!!
                                                                                                                                                                                                    .size() >= 5
                                                                                                                                                                                            ) {
                                                                                                                                                                                                itemAdapter_badge!!.addItem(
                                                                                                                                                                                                    Badge(
                                                                                                                                                                                                        "성공!!",
                                                                                                                                                                                                        R.drawable.incheon,
                                                                                                                                                                                                        strings[14]
                                                                                                                                                                                                    )
                                                                                                                                                                                                )
                                                                                                                                                                                            }
                                                                                                                                                                                            db!!.collection(
                                                                                                                                                                                                "travles"
                                                                                                                                                                                            )
                                                                                                                                                                                                .whereEqualTo(
                                                                                                                                                                                                    "id",
                                                                                                                                                                                                    activity!!.id
                                                                                                                                                                                                )
                                                                                                                                                                                                .whereEqualTo(
                                                                                                                                                                                                    "location",
                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                )
                                                                                                                                                                                                .get()
                                                                                                                                                                                                .addOnCompleteListener { task ->
                                                                                                                                                                                                    if (task.isSuccessful) {
                                                                                                                                                                                                        if (task.result!!
                                                                                                                                                                                                                .size() == 0
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                                                                .size() == 1
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "20%",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                                                                .size() == 2
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "40%",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                                                                .size() == 3
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "60%",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                                                                .size() == 4
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "80%",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        } else if (task.result!!
                                                                                                                                                                                                                .size() >= 5
                                                                                                                                                                                                        ) {
                                                                                                                                                                                                            itemAdapter_badge!!.addItem(
                                                                                                                                                                                                                Badge(
                                                                                                                                                                                                                    "성공!!",
                                                                                                                                                                                                                    R.drawable.jejo,
                                                                                                                                                                                                                    strings[15]
                                                                                                                                                                                                                )
                                                                                                                                                                                                            )
                                                                                                                                                                                                        }
                                                                                                                                                                                                        badges?.setAdapter(
                                                                                                                                                                                                            itemAdapter_badge
                                                                                                                                                                                                        )
                                                                                                                                                                                                        loading?.setVisibility(
                                                                                                                                                                                                            View.GONE
                                                                                                                                                                                                        )
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                            }
                                                                                                                        }
                                                                                                                }
                                                                                                            }
                                                                                                    }
                                                                                                }
                                                                                        }
                                                                                    }
                                                                            }
                                                                        }
                                                                }
                                                            }
                                                    }
                                                }
                                        }
                                    }
                            }
                        }
                } else {
                    Toast.makeText(context, "실패", Toast.LENGTH_LONG).show()
                }
            }.addOnFailureListener { e ->
                Toast.makeText(
                    context,
                    e.message.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }
        return rootView
    }
}