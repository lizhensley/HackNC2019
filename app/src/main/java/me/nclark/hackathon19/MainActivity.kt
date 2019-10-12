package me.nclark.hackathon19

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*
import me.nclark.hackathon19.sharing.SharingFragment
import me.nclark.hackathon19.signin.SigninActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if(!prefs.getBoolean("signinCompleted", false)) {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
        view_pager.adapter = MainActivityPagerAdapter(supportFragmentManager)
        tab_layout.setupWithViewPager(view_pager)
    }

    class MainActivityPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        override fun getCount(): Int = 3

        override fun getItem(position: Int): Fragment {
            return when(position) {
                1 -> SharingFragment()
                2 -> SharingFragment()
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