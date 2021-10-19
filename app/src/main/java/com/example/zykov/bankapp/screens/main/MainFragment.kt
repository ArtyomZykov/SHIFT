package com.example.zykov.bankapp.screens.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.zykov.bankapp.R
import com.example.zykov.bankapp.databinding.FragmentMainBinding
import com.example.zykov.bankapp.models.AppObject
import com.example.zykov.bankapp.models.Items
import com.example.zykov.bankapp.utilites.APP_ACTIVITY
import com.example.zykov.bankapp.parser.retrofit.RetrofitRepository


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter
    private lateinit var mObserverList: Observer<AppObject>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        setHasOptionsMenu(true)
        mAdapter = MainAdapter()
        mRecyclerView = mBinding.recyclerView
        mRecyclerView.adapter = mAdapter
        val repository = RetrofitRepository()
        val viewModelFactory = MainFragmentViewModelFactory(repository)
        mViewModel =
            ViewModelProvider(this, viewModelFactory).get(MainFragmentViewModel::class.java)
        mViewModel.getCourse()
        mObserverList = Observer {
            mAdapter.setList(it.currency.list!!)
        }
        mViewModel.mResponse.observe(this, mObserverList)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_actiom_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_converter -> {
                val bundle = Bundle()
                bundle.putSerializable("object", mViewModel.mResponse.value)
                APP_ACTIVITY.navController.navigate(
                    R.id.action_mainFragment_to_convertFragment,
                    bundle
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mRecyclerView.adapter = null
    }

    companion object {
        fun click(item: Items) {
            val bundle = Bundle()
            bundle.putSerializable("item", item)
            APP_ACTIVITY.navController.navigate(
                R.id.action_mainFragment_to_aboutCurrencyFragment, bundle
            )
        }
    }
}

