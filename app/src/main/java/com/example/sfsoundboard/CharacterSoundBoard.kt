package com.example.sfsoundboard

import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_SETTLING
import com.bumptech.glide.Glide
import com.example.sfsoundboard.adapters.CharacterSoundBoardAdapter
import com.example.sfsoundboard.sbkeys.SBButton
import kotlinx.android.synthetic.main.activity_character_board.*
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.activity_main.titleTV
import kotlinx.android.synthetic.main.activity_main.titleTV2
import kotlin.random.Random

class CharacterSoundBoard : AppCompatActivity() {

    val TAG: String = CharacterSoundBoard::class.simpleName.toString()
    val SPAN_COUNT = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_character_board)

        if (intent != null) {
            val button: SBButton? = intent.getParcelableExtra("button")
            setupSoundBoard(button)
            titleTV.text = button?.name
            titleTV2.text = button?.name
            Glide.with(this).load(button?.icon).into(characterIcon)
        }
    }

    private fun setupSoundBoard(button: SBButton?) {
        recyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        val adapter = CharacterSoundBoardAdapter()
        recyclerView.adapter = adapter

        val resId: Int = R.anim.grid_layout_animation_from_bottom
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        recyclerView.layoutAnimation = animation

        adapter.setButton(button)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == SCROLL_STATE_SETTLING) {
                    val height = recyclerView.height
                    val size: Int = recyclerView.childCount
                    for (i in 0 until size) {
                        val gridChild: ViewGroup = recyclerView.getChildAt(i) as ViewGroup
                        val childSize = gridChild.childCount
                        for (k in 0 until childSize) {
                            var whichAnim: Int = R.anim.shake2
                            if (i % 2 == 0) {
                                whichAnim = R.anim.shake3
                            }
                            val anim: Animation =
                                AnimationUtils.loadAnimation(gridChild.context, whichAnim)
                            anim.duration = Random.nextLong(250, 750)
                            gridChild.getChildAt(k).startAnimation(anim)
                        }
                    }
                }
            }
        })
    }
}