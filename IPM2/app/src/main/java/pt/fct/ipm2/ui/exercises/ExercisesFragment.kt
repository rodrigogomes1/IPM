package pt.fct.ipm2.ui.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.fct.ipm.ReciclerView.Exercises
import pt.fct.ipm.ReciclerView.ExercisesAdapter
import pt.fct.ipm2.R
import pt.fct.ipm2.ui.home.HomeViewModel

class ExercisesFragment : Fragment(),ExercisesAdapter.OnItemClickListener {

    private lateinit var exercisesViewModel: ExercisesViewModel
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerViewEx: RecyclerView
    private lateinit var viewAdapterEx: RecyclerView.Adapter<*>
    private lateinit var viewManagerEx: RecyclerView.LayoutManager
    lateinit var root:View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        exercisesViewModel =
                ViewModelProvider(this).get(ExercisesViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_exercises, container, false)
       // val textView: TextView = root.findViewById(R.id.text_gallery)
        //exercisesViewModel.text.observe(viewLifecycleOwner, Observer {
         //   textView.text = it
        //})

        val object1 = Exercises("ombro")
        val object2 = Exercises("perna")
        val object4 = Exercises("ombro")
        val object5 = Exercises("perna")


        val listOfExercisesTypes: MutableList<Exercises> = arrayListOf(
            object1,
            object2,
            object5,
            object4,
        )

        exercisesRecyclerView(listOfExercisesTypes)

        return root
    }



    fun exercisesRecyclerView( list :MutableList<Exercises>){
        viewManagerEx = GridLayoutManager(root.context, 2)//LinearLayoutManager(this)
        viewAdapterEx = ExercisesAdapter(list,this)

        recyclerViewEx = root.findViewById<RecyclerView>(R.id.Exercises).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManagerEx

            // specify an viewAdapter (see also next example)
            adapter = viewAdapterEx
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(root.context, "Item $position clicked", Toast.LENGTH_LONG).show()
    }

}