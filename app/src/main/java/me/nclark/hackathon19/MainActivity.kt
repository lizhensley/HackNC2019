package me.nclark.hackathon19
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import me.nclark.hackathon19.activity.ActivityFragment
import me.nclark.hackathon19.home.HomeFragment
import me.nclark.hackathon19.sharing.SharingFragment
import me.nclark.hackathon19.signin.SigninActivity
import java.util.*
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import java.text.SimpleDateFormat

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
        var format = SimpleDateFormat("yyyy-MM-dd")
        var dates: ArrayList<Date> = ArrayList<Date>(100)
        var data = File("app/src/main/assets/StudentData")
        var sc = Scanner(data);
        var PID = sc.nextLine().toInt()
        var username = sc.nextLine()
        var password = sc.nextLine()
        var totalSwipes = sc.nextLine().toInt()
        var swipesLeft = sc.nextLine().toInt()
        while(sc.hasNextLine()) {
            dates.add(format.parse(sc.nextLine()))
        }

        val array = arrayOfNulls<Date>(dates.size)

        user = User(PID, username, password, totalSwipes, swipesLeft, dates.toArray(array));
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