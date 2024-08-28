package com.ibm.chefcito.core.animation

import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation as AndroidScaleAnimation

class ScaleAnimation: AnimationStrategy {
    override fun animate(view: View, duration: Long) {
        val scaleAnimation = AndroidScaleAnimation(
            0.0f, 1.0f, 0.0f, 1.0f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        scaleAnimation.duration = duration
        view.startAnimation(scaleAnimation)
    }
}

