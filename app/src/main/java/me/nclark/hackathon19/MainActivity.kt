package me.nclark.hackathon19

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import me.nclark.hackathon19.signin.SigninActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if(!prefs.getBoolean("signinCompleted", false)) {
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
        }
    }

}