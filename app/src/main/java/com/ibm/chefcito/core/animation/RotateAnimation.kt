package com.ibm.chefcito.core.animation

import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation as AndroidRotateAnimation

class RotateAnimation: AnimationStrategy {
    override fun animate(
        view: View,
        duration: Long
    ) {
        val rotateAnimation = AndroidRotateAnimation(
            0.0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
        )
        rotateAnimation.duration = duration
        view.startAnimation(rotateAnimation)
    }
}

