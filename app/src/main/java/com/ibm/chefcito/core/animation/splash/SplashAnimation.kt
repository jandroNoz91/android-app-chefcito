package com.ibm.chefcito.core.animation.splash

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import com.ibm.chefcito.core.animation.AnimationStrategy

class SplashAnimation: AnimationStrategy {
    override fun animate(view: View, duration: Long) {
        val scaleAnimation = ScaleAnimation(
            0.5f, 1.0f,
            0.5f, 1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.duration = duration

        val translateAnimation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f,
            Animation.RELATIVE_TO_SELF,
            -1.0f,
            Animation.RELATIVE_TO_SELF,
            0.0f
        )

        translateAnimation.duration = duration
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(scaleAnimation)
        animationSet.addAnimation(translateAnimation)
        view.startAnimation(animationSet)
    }
}