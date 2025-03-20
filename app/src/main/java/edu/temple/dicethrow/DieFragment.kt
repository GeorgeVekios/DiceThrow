package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"
    private val PREVIOUS_DIE_VALUE = "previousDieValue"

    var currentDieValue = 0

    lateinit var dieTextView: TextView

    var dieSides: Int = 6

    lateinit var dieViewModel: DieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
        //dieViewModel = ViewModelProvider(requireActivity()).get(DieViewModel::class.java)
        dieViewModel = ViewModelProvider(requireActivity())[DieViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dieViewModel.getCurrentRoll().observe(viewLifecycleOwner) {
            dieTextView.text = it.toString()
        }

        //if (savedInstanceState == null)
//        throwDie()
//        else{
//            currentDieValue = savedInstanceState.getInt(PREVIOUS_DIE_VALUE)
//            dieTextView.text = currentDieValue.toString()
//        }
        if(dieViewModel.getCurrentRoll().value == null)
            dieViewModel.rollDie()
    }
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//        outState.putInt(PREVIOUS_DIE_VALUE, currentDieValue)
//    }

//    fun throwDie() {
//        //currentDieValue = (Random.nextInt(dieSides) + 1)
//        //dieTextView.text = currentDieValue.toString()
//        dieViewModel.setCurrentRoll(Random.nextInt(dieSides) + 1)
//    }
}