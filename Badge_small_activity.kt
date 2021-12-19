package org.techtown.app_project

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.ImageView
import org.techtown.app_project.R

class Badge_small_activity : AppCompatActivity() {
    var explains = arrayOf(
        "여러 명산들과 해상공원으로 산악과 해상관광을 같이 즐길 수 있는 곳",
        "우리나라의 오랜 전통과 역사의 때가 묻은 민족문화 창달의 대표",
        "자연을 만끽할 수 있는 유명한 드라이브 코스들이 즐비한 곳",
        "빼어난 자연경관으로 각종 레저스포츠가 유명한 곳",
        "문화· 예술· 레저 등 모든 걸 아우르는 여러 문화생활하기 좋은 곳",
        "각 지역의 전통과 고유색, 자연이 잘 살아 숨쉬는 곳",
        "한국 문화의 원형이 가장 잘 보존되어 있는 전통의 지역",
        "백제의 발자취를 고스란히 안고 있는 사찰과 문화재를 접할 수 있는 곳",
        "과거와 현재가 공존하며 하루가 다르게 변하는 우리나라 제 1의 도시",
        "각종 야경 명소, 야시장이 유명한 우리나라에서 가장 더운 지역",
        "도심의 야경과 각종 축제로 유명한 우리나라 제2의 수도",
        "역사, 도시, 자연등의 다양한 테마 여행이 가능한 도시",
        "'맛'과 '멋'이 조화를 이루며 남도의 문화를 이끄는 예향의 본고장",
        "일출이 가장 빨리 시작되는 간절곶과 해안을 따라 산책하기 좋은 도시",
        "살짝 비릿한 바다향이 매력적인 대표적인 해양 관광지.",
        "에메랄드빛 물빛이 인상적인, 섬 전체가 하나의 거대한 관광자원"
    )
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
//    var badge: ImageView? = null
//    var textview_name: TextView? = null
//    var textview_percent: TextView? = null
//    var explain: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_badge_small)
        var explain = findViewById<TextView>(R.id.textview_explain)
        var badge = findViewById<ImageView>(R.id.imageview_badge)
        var textview_name = findViewById<TextView>(R.id.textview_name)
        var textview_percent = findViewById<TextView>(R.id.textview_percent)
        explain = findViewById(R.id.textview_explain)
        val name = intent.getStringExtra("name")
        val percent = intent.getStringExtra("percent")
        val img = Integer.valueOf(intent.getStringExtra("img"))
        if (percent != "성공!!") {
           explain.visibility= View.GONE;
        } else {
            for (i in cities.indices) {
                if (cities[i] == name) {
                    explain.setText(explains[i])
                    break
                }
            }
            explain.setVisibility(View.VISIBLE)
        }
        badge.setImageResource(img)
        textview_name.setText(name)
        textview_percent.setText(percent)
    }
}