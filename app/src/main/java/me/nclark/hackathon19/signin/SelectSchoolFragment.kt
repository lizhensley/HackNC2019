package me.nclark.hackathon19.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_school_selection.*
import me.nclark.hackathon19.R

class SelectSchoolFragment : Fragment() {

    val schools = arrayOf("UNC")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_school_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter<String>(activity!!,
            android.R.layout.simple_spinner_item, schools)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        school_spinner.adapter = adapter
    }
}