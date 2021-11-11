package com.example.myapplication

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.get
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.app_objects.BannerItem
import com.example.myapplication.app_objects.ListItem
import com.example.myapplication.app_objects.StudentItem
import com.example.myapplication.main_adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
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
        ),
        StudentItem(
            name = "Пётр",
            secondName = "Петров",
            description = "Сеньор-помидор, 30 лет опыта С++, хочу попробовать себя в новом направлении",
            hasPortfolio = false,
        ),
        StudentItem(
            name = "Семён",
            secondName = "Сёменов",
            description = "Прошёл курсы Skillbox, SkillFactory, SkillShare, но не могу найти работу, помогите мне",
            hasPortfolio = false,
        ),
        StudentItem(
            name = "Андрей",
            secondName = "Андреев",
            description = "Мне не придумали длинного описания",
            hasPortfolio = true,
        ),
        StudentItem(
            name = "Егор",
            secondName = "Егоров",
            description = "Lorem ipsum dolor sit amet ya uchenik mne 19 let",
            hasPortfolio = true,
        ),
        BannerItem(
            title = "Новая заявка",
            description = "Здравствуйте, меня зовут Глеб, ещё не поздно подать заявку?"
        ),
        StudentItem(
            name = "Пётр",
            secondName = "Петров",
            description = "Сеньор-помидор, 30 лет опыта С++, хочу попробовать себя в новом направлении",
            hasPortfolio = false,
        ),
        StudentItem(
            name = "Семён",
            secondName = "Сёменов",
            description = "Прошёл курсы Skillbox, SkillFactory, SkillShare, но не могу найти работу, помогите мне",
            hasPortfolio = false,
        ),
        StudentItem(
            name = "Андрей",
            secondName = "Андреев",
            description = "Мне не придумали длинного описания",
            hasPortfolio = true,
        ),
        StudentItem(
            name = "Егор",
            secondName = "Егоров",
            description = "Lorem ipsum dolor sit amet ya uchenik mne 19 let",
            hasPortfolio = true,
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

        //Toast.makeText(context, "Пора покормить кота!", Toast.LENGTH_LONG).show()

        recycler_view?.apply {
            val mainAdapter = MainAdapter(onClick = {
                Toast.makeText(context, "clicked on $it", Toast.LENGTH_SHORT).show()
            })
            mainAdapter.dataList = dataList
            adapter = mainAdapter
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_list, container, false)


    }

}