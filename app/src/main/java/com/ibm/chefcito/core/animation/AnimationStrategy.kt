package com.ibm.chefcito.core.animation

import android.view.View

interface AnimationStrategy {
    fun animate(view: View, duration: Long = 1000L)
}