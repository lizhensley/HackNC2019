package me.nclark.hackathon19
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import me.nclark.hackathon19.activity.ActivityFragment
import me.nclark.hackathon19.home.HomeFragment
import me.nclark.hackathon19.sharing.SharingFragment
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var user: User

    /* creates User... for demo purposes, we'll eventually import the doc with the fake
        user data throw it in
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        view_pager.adapter = MainActivityPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_sharing)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_home)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_graph)

        val animDrawable = view_pager.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        var format = SimpleDateFormat("yyyy-MM-dd")
        var dates = arrayListOf<Date>()
        var data = assets.open("StudentData")
        var sc = Scanner(data)
        var PID = sc.nextLine().toInt()
        var username = sc.nextLine()
        var password = sc.nextLine()
        var totalSwipes = sc.nextLine().toInt()
        var swipesLeft = sc.nextLine().toInt()
        while(sc.hasNextLine()) {
            dates.add(format.parse(sc.nextLine()))
        }

        user = User(PID, username, password, totalSwipes, swipesLeft, dates.toTypedArray())
    }

    class MainActivityPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when(position) {
                1 -> HomeFragment()
                2 -> ActivityFragment()
                else -> SharingFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position) {
                0 -> "Sharing"
                1 -> "Home"
                2 -> "Activity"
                else -> ""
            }
        }
    }

}
