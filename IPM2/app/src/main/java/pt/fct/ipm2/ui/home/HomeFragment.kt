package pt.fct.ipm2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pt.fct.ipm.ReciclerView.Exercises
import pt.fct.ipm.ReciclerView.ExercisesAdapter
import pt.fct.ipm2.MainActivity
import pt.fct.ipm2.R

class HomeFragment : Fragment(), ExercisesAdapter.OnItemClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerViewEx: RecyclerView
    private lateinit var viewAdapterEx: RecyclerView.Adapter<*>
    private lateinit var viewManagerEx: RecyclerView.LayoutManager

    private lateinit var recyclerViewTr: RecyclerView
    private lateinit var viewAdapterTr: RecyclerView.Adapter<*>
    private lateinit var viewManagerTr: RecyclerView.LayoutManager

    lateinit var root:View

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
         root = inflater.inflate(R.layout.fragment_home, container, false)

        val showallex = root.findViewById<TextView>(R.id.showAllEx)
        showallex.setOnClickListener(){
            NavHostFragment.findNavController(this).navigate(R.id.nav_exercises)
        }

        val ahowalltr= root.findViewById<TextView>(R.id.showAllTre)
        ahowalltr.setOnClickListener(){
            NavHostFragment.findNavController(this).navigate(R.id.nav_trainings)
        }

        //val textView: TextView = root.findViewById(R.id.text_home)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
          //  textView.text = it
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


        val train1 = Exercises("Alongamentos")
        val train2 = Exercises("Trocicolo")
        val train3 = Exercises("Tendinite dedo")
        val train4 = Exercises("Entorse pé")

        val listOfTrainings: MutableList<Exercises> = arrayListOf(
            train1, train2,train3,train4)

        trainrecyclerView(listOfTrainings)
        exercisesRecyclerView(listOfExercisesTypes)

        return root
    }


    fun trainrecyclerView( list :MutableList<Exercises>){
        viewManagerTr = GridLayoutManager(root.context, 2)//LinearLayoutManager(this)
        viewAdapterTr = ExercisesAdapter(list,this)

        recyclerViewTr = root.findViewById<RecyclerView>(R.id.Trainings).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManagerTr

            // specify an viewAdapter (see also next example)
            adapter = viewAdapterTr
        }
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