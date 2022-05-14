package com.example.dancinglock

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickListeners()
    }

    private fun initClickListeners() {
        setVectorAnimationClickListener()
        setMotionClickListener()
        setDrawableClickListener()
    }

    private fun setDrawableClickListener() {
        val imageView = findViewById<ImageView>(R.id.animationDrawable)
        imageView.setBackgroundResource(R.drawable.ic_unlock_animation)
        imageView.setOnClickListener {
            val animationDrawable = imageView.background as AnimationDrawable
            animationDrawable.start()
        }
    }

    private fun setMotionClickListener() {
        val motionLayout : MotionLayout = findViewById(R.id.motionLayout)
        val view = findViewById<ImageView>(R.id.motionLayoutButton)
        view.setOnClickListener {
            motionLayout.viewTransition(R.id.shakeUnlockButton, view)
        }
    }

    private fun setVectorAnimationClickListener() {
        val vectorDrawableAnimationButton: ImageView = findViewById<ImageView>(R.id.objectAnimator)
        val avd = vectorDrawableAnimationButton.drawable as AnimatedVectorDrawable
        avd.registerAnimationCallback(callBack)
        vectorDrawableAnimationButton.setOnClickListener {
            avd.start()
        }
    }

    object callBack: Animatable2.AnimationCallback(){
        override fun onAnimationEnd(drawable: Drawable?) {
            super.onAnimationEnd(drawable)
            val avd = drawable as AnimatedVectorDrawable
            avd.reset()
            avd.start()
        }
    }
}