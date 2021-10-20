package com.example.fragments.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.example.fragments.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toNextFragmentButton.setOnClickListener { toNextFragment() }
        toPreviousFragmentButton.setOnClickListener { activity?.onBackPressed() }
    }

    private fun toNextFragment() {
        fragmentManager?.commit {
            replace<SecondFragment>(R.id.container)
            setReorderingAllowed(true)
            addToBackStack("SecondFragment")
        }
    }
}