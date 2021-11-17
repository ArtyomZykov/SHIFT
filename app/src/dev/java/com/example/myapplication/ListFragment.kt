package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.app_objects.BannerItem
import com.example.myapplication.app_objects.ListItem
import com.example.myapplication.app_objects.StudentItem
import com.example.myapplication.main_adapter.MainAdapter
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {
    val dataList: List<ListItem> = listOf(
        StudentItem(
            name = "Иван",
            secondName = "Иванов",
            description = "Только что выпустился из универа, с Android знаком не сильно",
            hasPortfolio = true,
        ),
        BannerItem(
            title = "Новая заявка",
            description = "Здравствуйте, меня зовут Глеб, ещё не поздно подать заявку?"
        )
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        add_btn.setOnClickListener {

            parentFragmentManager.commit {
                setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                replace<EditFragment>(R.id.container)
                setReorderingAllowed(true)
                addToBackStack("EditFragment")
            }
        }

        recycler_view?.apply {
            val mainAdapter = MainAdapter(onClick = {
                Toast.makeText(context, "clicked on $it", Toast.LENGTH_SHORT).show()
            })
            mainAdapter.dataList = dataList
            adapter = mainAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

}