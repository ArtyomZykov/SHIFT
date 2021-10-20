package com.example.fragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments.R
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toNextFragmentButton.setOnClickListener { toNextFragment() }
        toPreviousFragmentButton.setOnClickListener {  activity?.onBackPressed() }
    }



    private fun toNextFragment() {
        fragmentManager?.commit {
            replace<ThirdFragment>(R.id.container)
            setReorderingAllowed(true)
            addToBackStack("ThirdFragment")
        }
    }

}