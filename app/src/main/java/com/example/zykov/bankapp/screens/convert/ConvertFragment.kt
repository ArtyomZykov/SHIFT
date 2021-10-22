package com.example.zykov.bankapp.screens.convert

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.databinding.FragmentConvertBinding
import com.example.zykov.bankapp.models.AppObject
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.zykov.bankapp.R
import com.example.zykov.bankapp.utilites.APP_ACTIVITY


class ConvertFragment : Fragment() {
    private var _binding: FragmentConvertBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: ConvertFragmentViewModel
    private var _object: AppObject? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConvertBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mViewModel = ViewModelProvider(this).get(ConvertFragmentViewModel::class.java)
        _object = arguments?.getSerializable("object") as AppObject
        mBinding.editTextNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(
                textNumber: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (textNumber == null || textNumber.isEmpty()) {
                    mBinding.resultText.text = ""
                } else {
                    val amount: Double = textNumber.toString().toDouble()
                    val rate: String = mBinding.autoCompleteTextView.text.toString()
                    try {
                        mBinding.resultText.text = mViewModel.converter(
                            amount = amount,
                            rate = mViewModel.getValueByName(rate, _object?.currency?.list)
                        ).toString()
                    } catch (e: IllegalArgumentException) {
                        Toast.makeText(APP_ACTIVITY, R.string.select_currency, LENGTH_SHORT).show()
                    }
                }
            }
        })
        mBinding.autoCompleteTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(str: CharSequence?, start: Int, before: Int, count: Int) {
                val textNumber: String = mBinding.editTextNumber.text.toString()
                if (textNumber.isEmpty()) {
                    mBinding.resultText.text = ""
                } else {
                    val amount: Double = textNumber.toDouble()
                    val rate: String = str.toString()
                    try {
                        mBinding.resultText.text = mViewModel.converter(
                            amount = amount,
                            rate = mViewModel.getValueByName(rate, _object?.currency?.list)
                        ).toString()
                    } catch (e: IllegalArgumentException) {
                        mBinding.resultText.text = ""
                        Toast.makeText(APP_ACTIVITY, R.string.display_the_amount_of_currency, LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val arrayAdapter = ArrayAdapter(
            requireContext(),
            R.layout.dropdown_item,
            _object?.currency?.list!!.map { it.name })
        mBinding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}