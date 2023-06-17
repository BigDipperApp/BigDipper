package com.example.bigdipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.bigdipper.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding

    private var welcomeTitleList = mutableListOf<String>("내가 읽고 싶었던 책을\n" +
            "다른 사람들과 함께","북클럽에 가장\n" +
            "최적화된 플랫폼", "북두칠성은 당신의\n" +
            "완독메이트")
    private var welcomeDescriptionList = mutableListOf<String>("나와 비슷한 관심사를 가진 사람들과 함께,\n" +
            "그동안 읽고 싶었던 책을 함께 읽어요.",  "공지사항, 인증, 글 작성을 한 곳에서!\n이젠 책 읽고 생각을 나누는데만 집중하세요.",
        "완독하고 북클럽에 참여할 때마다 성장하는 별을 보며 자신이 얼마나 발전했는지 알 수 있어요 :)")
    private var welcomeAnimationList = mutableListOf<Int>(R.raw.welcome_guide_img1, R.raw.welcome_guide_img2, R.raw.welcome_guide_img3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLayout()
    }
    fun initLayout(){
        binding.apply{
            welcomeGuideView.adapter = ViewPagerAdapter(welcomeTitleList, welcomeDescriptionList, welcomeAnimationList)
            welcomeGuideView.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            welcomePageIndicator.setViewPager(welcomeGuideView)
            welcomeContinueBtn.setOnClickListener {
                welcomeGuideView.apply{
                    beginFakeDrag()
                    for(i in 1..3){
                        fakeDragBy(-10f)
                        fakeDragBy(-10f)
                        fakeDragBy(-10f)
                    }
                    endFakeDrag()
                }
            }
        }

    }
}