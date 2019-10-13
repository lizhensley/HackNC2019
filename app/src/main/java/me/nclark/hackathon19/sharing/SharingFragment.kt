package me.nclark.hackathon19.sharing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sharing.*
import me.nclark.hackathon19.R

class SharingFragment : Fragment(), View.OnClickListener {

    override fun onClick(v: View?) {
        startActivity(Intent(activity, ShareSwipesActivity::class.java))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sharing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        share_friend_button.setOnClickListener(this)
        donate_swipes_button.setOnClickListener(this)
    }

}