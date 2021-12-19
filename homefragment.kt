package org.techtown.app_project

import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class homefragment : Fragment() {
    var badges: RecyclerView? = null
    var pictures: RecyclerView? = null
    var db: FirebaseFirestore? = null
    var itemAdapter_badge: ItemAdapter_badge? = null
    var itemAdapter_travel: ItemAdapter_travel? = null

    var gn:ImageView? =null
    var gb:ImageView? =null
    var cb:ImageView? =null
    var go:ImageView? =null

    var gd:ImageView? =null
    var jn:ImageView? =null
    var jb:ImageView? =null
    var cn:ImageView? =null

    var so:ImageView? =null
    var dg:ImageView? =null
    var bs:ImageView? =null
    var dj:ImageView? =null

    var gj:ImageView? =null
    var us:ImageView? =null
    var ic:ImageView? =null
    var jj:ImageView? =null
    var loading: ProgressBar? = null
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
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        gn = rootView.findViewById(R.id.gn_tree);
        gb = rootView.findViewById(R.id.gb_tree);
        cb = rootView.findViewById(R.id.cb_tree);
        go = rootView.findViewById(R.id.go_tree);

        gd = rootView.findViewById(R.id.gd_tree);
        jn = rootView.findViewById(R.id.jn_tree);
        jb = rootView.findViewById(R.id.jb_tree);
        cn = rootView.findViewById(R.id.cn_tree);

        so = rootView.findViewById(R.id.so_tree);
        dg = rootView.findViewById(R.id.dg_tree);
        bs = rootView.findViewById(R.id.bs_tree);
        dj = rootView.findViewById(R.id.dj_tree);

        gj = rootView.findViewById(R.id.gj_tree);
        us = rootView.findViewById(R.id.us_tree);
        ic = rootView.findViewById(R.id.ic_tree);
        jj = rootView.findViewById(R.id.jj_tree);

        db = FirebaseFirestore.getInstance()
        pictures = rootView.findViewById(R.id.recyclerview_pictures)
        badges = rootView.findViewById(R.id.recyclerview_badges)
        loading = rootView.findViewById(R.id.loading)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val layoutManager2 = LinearLayoutManager(context)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        badges?.setLayoutManager(layoutManager)
        pictures?.setLayoutManager(layoutManager2)
        return rootView
    }

    override fun onStart() {
        super.onStart()
        var activity: MainActivity =getActivity() as MainActivity
        loading!!.visibility = View.VISIBLE
        itemAdapter_travel = ItemAdapter_travel()
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        itemAdapter_travel!!.addItem(
                            Travel(
                                document?.getString("name"),
                                document?.getString("oneline"),
                                document?.getString("recomend"),
                                document?.getString("feel"),
                                document?.getString("date"),
                                document?.getString("location"),
                                document?.getString("location2"),
                                document?.getString("img1"),
                                document?.getString("img2"),
                                document?.getString("img3"),
                                document?.getString("img4"),
                                document?.getString("num")
                            )
                        )
                    }
                    pictures!!.adapter = itemAdapter_travel
                    loading!!.visibility = View.GONE
                }
            }
        itemAdapter_badge = ItemAdapter_badge()
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[0])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.gungnam));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.gungnam,"경상남도"))
                        gn!!.visibility = View.VISIBLE;
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.gungnam,"경상남도"))
                        gn!!.visibility = View.VISIBLE;
                        gn!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.gungnam,"경상남도"))
                        gn!!.visibility = View.VISIBLE;
                        gn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.gungnam,"경상남도"))
                        gn!!.visibility = View.VISIBLE;
                        gn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.gungnam,"경상남도"))
                        gn!!.visibility = View.VISIBLE;
                        gn!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[1])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.gungbok));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.gungbok,"경상북도"))
                        gb!!.visibility = View.VISIBLE;
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.gungbok,"경상북도"))
                        gb!!.visibility = View.VISIBLE;
                        gb!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.gungbok,"경상북도"))
                        gb!!.visibility = View.VISIBLE;
                        gb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.gungbok,"경상북도"))
                        gb!!.visibility = View.VISIBLE;
                        gb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.gungbok,"경상북도"))
                        gb!!.visibility = View.VISIBLE;
                        gb!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[2])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.chongbok));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.chongbok,"충청북도"))
                        cb!!.visibility = View.VISIBLE;
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.chongbok,"충청북도"))
                        cb!!.visibility = View.VISIBLE;
                        cb!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.chongbok,"충청북도"))
                        cb!!.visibility = View.VISIBLE;
                        cb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.chongbok,"충청북도"))
                        cb!!.visibility = View.VISIBLE;
                        cb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.chongbok,"충청북도"))
                        cb!!.visibility = View.VISIBLE;
                        cb!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[3])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.gangone));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.gangone,"강원도"))
                        go!!.visibility = View.VISIBLE;
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.gangone,"강원도"))
                        go!!.visibility = View.VISIBLE;
                        go!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.gangone,"강원도"))
                        go!!.visibility = View.VISIBLE;
                        go!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.gangone,"강원도"))
                        go!!.visibility = View.VISIBLE;
                        go!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.gangone,"강원도"))
                        go!!.visibility = View.VISIBLE;
                        go!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[4])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.gunggido));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.gunggido,"경기도"))
                        gd!!.visibility = View.VISIBLE;
                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.gunggido,"경기도"))
                        gd!!.visibility = View.VISIBLE;
                        gd!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.gunggido,"경기도"))
                        gd!!.visibility = View.VISIBLE;
                        gd!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.gunggido,"경기도"))
                        gd!!.visibility = View.VISIBLE;
                        gd!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.gunggido,"경기도"))
                        gd!!.visibility = View.VISIBLE;
                        gd!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[5])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.junnam));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.junnam,"전라남도"))
                        jn!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.junnam,"전라남도"))
                        jn!!.visibility = View.VISIBLE;
                        jn!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.junnam,"전라남도"))
                        jn!!.visibility = View.VISIBLE
                        jn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.junnam,"전라남도"))
                        jn!!.visibility = View.VISIBLE;
                        jn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.junnam,"전라남도"))
                        jn!!.visibility = View.VISIBLE
                        jn!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[6])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.junbok));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.junbok,"전라북도"))
                        jb!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.junbok,"전라북도"))
                        jb!!.visibility = View.VISIBLE;
                        jb!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.junbok,"전라북도"))
                        jb!!.visibility = View.VISIBLE;
                        jb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.junbok,"전라북도"))
                        jb!!.visibility = View.VISIBLE;
                        jb!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.junbok,"전라북도"))
                        jb!!.visibility = View.VISIBLE;
                        jb!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[7])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.chungnam));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.chungnam,"충청남도"))
                        cn!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.chungnam,"충청남도"))
                        cn!!.visibility = View.VISIBLE;
                        cn!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.chungnam,"충청남도"))
                        cn!!.visibility = View.VISIBLE;
                        cn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.chungnam,"충청남도"))
                        cn!!.visibility = View.VISIBLE;
                        cn!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.chungnam,"충청남도"))
                        cn!!.visibility = View.VISIBLE;
                        cn!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[8])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.seoul));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.seoul,"서울특별시"))
                        so!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.seoul,"서울특별시"))
                        so!!.visibility = View.VISIBLE;
                        so!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.seoul,"서울특별시"))
                        so!!.visibility = View.VISIBLE;
                        so!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.seoul,"서울특별시"))
                        so!!.visibility = View.VISIBLE;
                        so!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.seoul,"서울특별시"))
                        so!!.visibility = View.VISIBLE;
                        so!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[9])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.daegu));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.daegu,"대구"))
                        dg!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.daegu,"대구"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.daegu,"대구"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.daegu,"대구"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.daegu,"대구"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[10])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.busan));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.busan,"부산광역시"))
                        bs!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.busan,"부산광역시"))
                        bs!!.visibility = View.VISIBLE;
                        bs!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.busan,"부산광역시"))
                        bs!!.visibility = View.VISIBLE;
                        bs!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.busan,"부산광역시"))
                        bs!!.visibility = View.VISIBLE;
                        bs!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.busan,"부산광역시"))
                        bs!!.visibility = View.VISIBLE;
                        bs!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[11])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.daegun));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.daegun,"대전광역시"))
                        dg!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.daegun,"대전광역시"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.daegun,"대전광역시"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.daegun,"대전광역시"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.daegun,"대전광역시"))
                        dg!!.visibility = View.VISIBLE;
                        dg!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[12])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.guangjo));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.guangjo,"광주광역시"))
                        gj!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.guangjo,"광주광역시"))
                        gj!!.visibility = View.VISIBLE;
                        gj!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.guangjo,"광주광역시"))
                        gj!!.visibility = View.VISIBLE;
                        gj!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.guangjo,"광주광역시"))
                        gj!!.visibility = View.VISIBLE;
                        gj!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.guangjo,"광주광역시"))
                        gj!!.visibility = View.VISIBLE;
                        gj!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[13])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.ulsan));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.ulsan,"울산광역시"))
                        us!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.ulsan,"울산광역시"))
                        us!!.visibility = View.VISIBLE;
                        us!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.ulsan,"울산광역시"))
                        us!!.visibility = View.VISIBLE;
                        us!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.ulsan,"울산광역시"))
                        us!!.visibility = View.VISIBLE;
                        us!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.ulsan,"울산광역시"))
                        us!!.visibility = View.VISIBLE;
                        us!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[14])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.incheon));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.incheon,"인천광역시"))
                        ic!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.incheon,"인천광역시"))
                        ic!!.visibility = View.VISIBLE;
                        ic!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.incheon,"인천광역시"))
                        ic!!.visibility = View.VISIBLE;
                        ic!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.incheon,"인천광역시"))
                        ic!!.visibility = View.VISIBLE;
                        ic!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.incheon,"인천광역시"))
                        ic!!.visibility = View.VISIBLE;
                        ic!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
        db!!.collection("travles")
            .whereEqualTo("id", activity!!.id)
            .whereEqualTo("location", strings[15])
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result!!.size() == 0) {
//                                itemAdapter_badge.addItem(new Badge("", R.drawable.jejo));
                    } else if (task.result!!.size() == 1) {
                        itemAdapter_badge!!.addItem(Badge("20%", R.drawable.jejo,"제주특별자치도"))
                        jj!!.visibility = View.VISIBLE;

                    } else if (task.result!!.size() == 2) {
                        itemAdapter_badge!!.addItem(Badge("40%", R.drawable.jejo,"제주특별자치도"))
                        jj!!.visibility = View.VISIBLE;
                        jj!!.setImageResource(R.drawable.tree2)
                    } else if (task.result!!.size() == 3) {
                        itemAdapter_badge!!.addItem(Badge("60%", R.drawable.jejo,"제주특별자치도"))
                        jj!!.visibility = View.VISIBLE;
                        jj!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() == 4) {
                        itemAdapter_badge!!.addItem(Badge("80%", R.drawable.jejo,"제주특별자치도"))
                        jj!!.visibility = View.VISIBLE;
                        jj!!.setImageResource(R.drawable.tree3)
                    } else if (task.result!!.size() >= 5) {
                        itemAdapter_badge!!.addItem(Badge("성공!!", R.drawable.jejo,"제주특별자치도"))
                        jj!!.visibility = View.VISIBLE;
                        jj!!.setImageResource(R.drawable.tree4)
                    }
                    badges!!.adapter = itemAdapter_badge
                }
            }
    }
}