package com.example.savestate.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.savestate.R
import kotlinx.android.synthetic.main.fragment_start.*


class StartFragment : Fragment() {

    private companion object {
        const val REQUEST_CODE = 3184

        const val APP_PREFERENCES = "AppSettings"
        const val APP_PREFERENCES_FIRST_RUN_BOOL = "first_run_key"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!getFirstRunState())
            goToMainFragment()
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPermissionButton.setOnClickListener { checkPermission() }
    }

    private fun getFirstRunState() : Boolean =
        requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
            .getBoolean(APP_PREFERENCES_FIRST_RUN_BOOL, true)


    private fun saveFirstRunState(flag: Boolean) {
        requireActivity().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(APP_PREFERENCES_FIRST_RUN_BOOL, flag)
            .apply()
    }

    private fun checkPermission() {
        if (isPermissionGranted()) {
            goToMainFragment()
        } else {
            requestPermission()
        }
    }

    private fun goToMainFragment() {
        saveFirstRunState(false)
        activity?.supportFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        activity?.supportFragmentManager?.commit {
            replace<MainFragment>(R.id.container)
            setReorderingAllowed(true)
            addToBackStack("MainFragment")
        }
    }

    private fun isPermissionGranted(): Boolean =
        PackageManager.PERMISSION_GRANTED ==
                ContextCompat.checkSelfPermission(
                    context?.applicationContext!!,
                    Manifest.permission.READ_CONTACTS
                )

    private fun requestPermission() {
        requestPermissions(
            arrayOf(Manifest.permission.READ_CONTACTS),
            REQUEST_CODE
        )
    }

}