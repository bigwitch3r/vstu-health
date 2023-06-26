package ru.vstu.health.ui.dashboard

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import ru.vstu.health.DataPoint
import ru.vstu.health.GraphView
import ru.vstu.health.databinding.FragmentDashboardBinding
import ru.vstu.health.entities.ActivityMeasurements
import java.time.LocalDateTime
import java.util.Random

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var graph_view: GraphView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/

        val graphView: GraphView = binding.graphView
        graphView.setData(generateRandomDataPoints())

        return root
    }

    private fun generateRandomDataPoints(): List<DataPoint> {
        val random = Random()
        return (0..20).map {
            DataPoint(it, random.nextInt(50) + 1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}