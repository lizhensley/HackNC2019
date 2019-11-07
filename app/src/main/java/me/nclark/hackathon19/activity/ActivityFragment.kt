package me.nclark.hackathon19.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter
import com.jjoe64.graphview.series.BarGraphSeries
import me.nclark.hackathon19.R
import com.jjoe64.graphview.series.DataPoint
import kotlinx.android.synthetic.main.fragment_activity.*
import me.nclark.hackathon19.MainActivity

class ActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = activity as MainActivity
        val user = activity.user
        val dates = user.getDays()
        val swipesPerDay = user.getNumSwipesPerDay()

        val data = arrayOfNulls<DataPoint>(dates.size)

        for ((i, day) in dates.withIndex()) {
            data[i] = DataPoint(day, swipesPerDay[i] * 1.0)
        }

        val series = BarGraphSeries<DataPoint>(data)
        graph.addSeries(series)
        graph.gridLabelRenderer.labelFormatter = DateAsXAxisLabelFormatter(activity)
    }

}
