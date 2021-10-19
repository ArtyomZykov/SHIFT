package com.example.zykov.bankapp.screens.currency


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zykov.bankapp.databinding.FragmentAboutCurrencyBinding
import com.example.zykov.bankapp.models.Items

class AboutCurrencyFragment : Fragment() {
    private var _binding: FragmentAboutCurrencyBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AboutCurrencyFragmentViewModel
    private lateinit var mCurrentItem: Items

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutCurrencyBinding.inflate(layoutInflater, container, false)
        mCurrentItem = arguments?.getSerializable("item") as Items
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mBinding.textId.text = mCurrentItem.id
        mBinding.textNumCode.text = mCurrentItem.numCode
        mBinding.textCharCode.text = mCurrentItem.charCode
        mBinding.textNominal.text = mCurrentItem.nominal.toString()
        mBinding.textName.text = mCurrentItem.name
        mBinding.textValue.text = mCurrentItem.value.toString()
        mBinding.textPrevious.text = mCurrentItem.previous.toString()
        mViewModel = ViewModelProvider(this).get(AboutCurrencyFragmentViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

