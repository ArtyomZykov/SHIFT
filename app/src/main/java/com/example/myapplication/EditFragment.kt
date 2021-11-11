package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Instrumentation
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_list.*
import android.view.animation.TranslateAnimation

import android.view.animation.Animation
import android.view.animation.AccelerateInterpolator





class EditFragment : Fragment() {
    var shortAnimationDuration: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        enter_btn.setOnClickListener {

            if (editText.text.toString().isEmpty()) {
                editText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake))
            } else {
                //editText.visibility = View.INVISIBLE
                //enter_btn.visibility = View.INVISIBLE
                //progressBar.visibility = View.VISIBLE

                val anim_1 = ObjectAnimator.ofFloat(editText, View.ALPHA, 0f)
                    .setDuration(300)
                val anim_2 = ObjectAnimator.ofFloat(enter_btn, View.ALPHA, 0f)
                    .setDuration(300)
                val anim_3 = ObjectAnimator.ofFloat(progressBar, View.ALPHA, 1f)
                    .setDuration(500)


                progressBar.animate()
                    .alpha(0f)
                    .setDuration(shortAnimationDuration.toLong())
                    .setListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            progressBar.visibility = View.VISIBLE
                        }
                    })

                val animatorSet = AnimatorSet()
                animatorSet.play(anim_1)
                    .with(anim_2)
                    .before(anim_3)

                animatorSet.start()


                animatorSet.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationStart(animation: Animator) {

                    }

                    override fun onAnimationEnd(animation: Animator) {
                        activity?.onBackPressed()
                    }
                })

            }

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)

    }

}