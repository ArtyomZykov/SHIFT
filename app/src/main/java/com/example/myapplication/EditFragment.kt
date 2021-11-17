package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_edit.*


class EditFragment : Fragment() {

    var shortAnimationDuration: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        enter_btn.setOnClickListener { startAnim() }
    }

    private fun startAnim() {
        if (editText.text.toString().isEmpty()) {
            editText.startAnimation(AnimationUtils.loadAnimation(context, R.anim.shake))
        } else {

            val hideEditText = ObjectAnimator.ofFloat(editText, View.ALPHA, 0f)
                .setDuration(300)

            val hideEnterBtn = ObjectAnimator.ofFloat(enter_btn, View.ALPHA, 0f)
                .setDuration(300)

            val visibleProgressBar = ObjectAnimator.ofFloat(progressBar, View.ALPHA, 1f)
                .setDuration(800)

            progressBar.animate()
                .alpha(0f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        progressBar.visibility = View.VISIBLE
                    }
                })

            val animatorSet = AnimatorSet()
            animatorSet.play(hideEditText)
                .with(hideEnterBtn)
                .before(visibleProgressBar)

            animatorSet.start()

            animatorSet.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    activity?.onBackPressed()
                }
            })

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

}