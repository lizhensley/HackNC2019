package me.nclark.hackathon19.sharing

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_share_swipes.*
import me.nclark.hackathon19.R

class ShareSwipesActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        swipes_feedback_text.text = progress.toString()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    override fun onStopTrackingTouch(seekBar: SeekBar?) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_swipes)
        seekBar.setOnSeekBarChangeListener(this)
    }

}