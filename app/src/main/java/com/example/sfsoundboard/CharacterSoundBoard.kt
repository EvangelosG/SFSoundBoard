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
import com.example.sfsoundboard.adapters.SoundBoardAdapter
import com.example.sfsoundboard.sbkeys.SBButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class CharacterSoundBoard : AppCompatActivity() {

    val TAG: String = CharacterSoundBoard::class.simpleName.toString()
    val SPAN_COUNT = 4;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)
        setupSoundBoard()
    }

    private fun setupSoundBoard() {
        val soundBoardButtons: MutableList<SBButton> = ArrayList()
        soundBoardButtons.add(SBButton(R.drawable.alex_icon, getString(R.string.Alex), mutableListOf(R.raw.alex_0, R.raw.alex_1, R.raw.alex_2, R.raw.alex_3, R.raw.alex_4, R.raw.alex_5, R.raw.alex_6, R.raw.alex_7, R.raw.alex_8, R.raw.alex_9, R.raw.alex_10, R.raw.alex_11)))
        soundBoardButtons.add(SBButton(R.drawable.balrog_icon, getString(R.string.Balrog), mutableListOf(R.raw.balrog_0, R.raw.balrog_1, R.raw.balrog_2, R.raw.balrog_3, R.raw.balrog_4, R.raw.balrog_5, R.raw.balrog_6, R.raw.balrog_7, R.raw.balrog_8, R.raw.balrog_9, R.raw.balrog_10, R.raw.balrog_11)))
        soundBoardButtons.add(SBButton(R.drawable.birdie_icon, getString(R.string.Birdie), mutableListOf(R.raw.birdie_0, R.raw.birdie_1, R.raw.birdie_2, R.raw.birdie_3, R.raw.birdie_4, R.raw.birdie_5, R.raw.birdie_6, R.raw.birdie_7, R.raw.birdie_8, R.raw.birdie_9, R.raw.birdie_10, R.raw.birdie_11)))
        soundBoardButtons.add(SBButton(R.drawable.cammy_icon, getString(R.string.Cammy), mutableListOf(R.raw.cammy_0, R.raw.cammy_1, R.raw.cammy_2, R.raw.cammy_3, R.raw.cammy_4, R.raw.cammy_5, R.raw.cammy_6, R.raw.cammy_7, R.raw.cammy_8, R.raw.cammy_9, R.raw.cammy_10, R.raw.cammy_11)))
        soundBoardButtons.add(SBButton(R.drawable.chun_icon, getString(R.string.ChunLi), mutableListOf(R.raw.chun_0, R.raw.chun_1, R.raw.chun_2, R.raw.chun_3, R.raw.chun_4, R.raw.chun_5, R.raw.chun_6, R.raw.chun_7, R.raw.chun_8, R.raw.chun_9, R.raw.chun_10, R.raw.chun_11)))
        soundBoardButtons.add(SBButton(R.drawable.dhalsim_icon, getString(R.string.Dhalsim), mutableListOf(R.raw.dhalsim_0, R.raw.dhalsim_1, R.raw.dhalsim_2, R.raw.dhalsim_3, R.raw.dhalsim_4, R.raw.dhalsim_5, R.raw.dhalsim_6, R.raw.dhalsim_7, R.raw.dhalsim_8, R.raw.dhalsim_9, R.raw.dhalsim_10, R.raw.dhalsim_11)))
        soundBoardButtons.add(SBButton(R.drawable.guile_icon, getString(R.string.Guile), mutableListOf(R.raw.guile_0, R.raw.guile_1, R.raw.guile_2, R.raw.guile_3, R.raw.guile_4, R.raw.guile_5, R.raw.guile_6, R.raw.guile_7, R.raw.guile_8, R.raw.guile_9, R.raw.guile_10, R.raw.guile_11)))
        soundBoardButtons.add(SBButton(R.drawable.ibuki_icon, getString(R.string.Ibuki), mutableListOf(R.raw.ibuki_0, R.raw.ibuki_1, R.raw.ibuki_2, R.raw.ibuki_3, R.raw.ibuki_4, R.raw.ibuki_5, R.raw.ibuki_6, R.raw.ibuki_7, R.raw.ibuki_8, R.raw.ibuki_9, R.raw.ibuki_10, R.raw.ibuki_11, R.raw.ibuki_12, R.raw.ibuki_13)))
        soundBoardButtons.add(SBButton(R.drawable.karin_icon, getString(R.string.Karin), mutableListOf(R.raw.karin_0, R.raw.karin_1, R.raw.karin_2, R.raw.karin_3, R.raw.karin_4, R.raw.karin_5, R.raw.karin_6, R.raw.karin_7, R.raw.karin_8, R.raw.karin_9, R.raw.karin_10, R.raw.karin_11, R.raw.karin_12, R.raw.karin_13, R.raw.karin_14)))
        soundBoardButtons.add(SBButton(R.drawable.ken_icon, getString(R.string.Ken), mutableListOf(R.raw.ken_0, R.raw.ken_1, R.raw.ken_2, R.raw.ken_3, R.raw.ken_4, R.raw.ken_5, R.raw.ken_6, R.raw.ken_7, R.raw.ken_8, R.raw.ken_9, R.raw.ken_10, R.raw.ken_11, R.raw.ken_12)))
        soundBoardButtons.add(SBButton(R.drawable.mika_icon, getString(R.string.Mika), mutableListOf(R.raw.mika_0, R.raw.mika_1, R.raw.mika_2, R.raw.mika_3, R.raw.mika_4, R.raw.mika_5, R.raw.mika_6, R.raw.mika_7, R.raw.mika_8, R.raw.mika_9, R.raw.mika_10, R.raw.mika_11, R.raw.mika_12, R.raw.mika_13)))
        soundBoardButtons.add(SBButton(R.drawable.nash_icon, getString(R.string.Nash), mutableListOf(R.raw.nash_0, R.raw.nash_1, R.raw.nash_2, R.raw.nash_3, R.raw.nash_4, R.raw.nash_5, R.raw.nash_6, R.raw.nash_7, R.raw.nash_8, R.raw.nash_9, R.raw.nash_10, R.raw.nash_11, R.raw.nash_12, R.raw.nash_13, R.raw.nash_14, R.raw.nash_15)))
        soundBoardButtons.add(SBButton(R.drawable.ryu_icon, getString(R.string.Ryu), mutableListOf(R.raw.ryu_0, R.raw.ryu_1, R.raw.ryu_2, R.raw.ryu_3, R.raw.ryu_4, R.raw.ryu_5, R.raw.ryu_6, R.raw.ryu_7, R.raw.ryu_8, R.raw.ryu_9, R.raw.ryu_10, R.raw.ryu_11, R.raw.ryu_12, R.raw.ryu_13, R.raw.ryu_14)))
        soundBoardButtons.add(SBButton(R.drawable.urien_icon, getString(R.string.Urien), mutableListOf(R.raw.urien_0, R.raw.urien_1, R.raw.urien_2, R.raw.urien_3, R.raw.urien_4, R.raw.urien_5, R.raw.urien_6, R.raw.urien_7, R.raw.urien_8, R.raw.urien_9, R.raw.urien_10, R.raw.urien_11, R.raw.urien_12, R.raw.urien_13, R.raw.urien_14, R.raw.urien_15, R.raw.urien_16)))
        soundBoardButtons.add(SBButton(R.drawable.vega_icon, getString(R.string.Vega), mutableListOf(R.raw.vega_0, R.raw.vega_1, R.raw.vega_2, R.raw.vega_3, R.raw.vega_4, R.raw.vega_5, R.raw.vega_6, R.raw.vega_7, R.raw.vega_8, R.raw.vega_9, R.raw.vega_10, R.raw.vega_11, R.raw.vega_12, R.raw.vega_13, R.raw.vega_14, R.raw.vega_15)))
        soundBoardButtons.add(SBButton(R.drawable.zangief_icon, getString(R.string.Zangief), mutableListOf(R.raw.zangief_0, R.raw.zangief_1, R.raw.zangief_2, R.raw.zangief_3, R.raw.zangief_4, R.raw.zangief_5, R.raw.zangief_6, R.raw.zangief_7, R.raw.zangief_8, R.raw.zangief_9, R.raw.zangief_10, R.raw.zangief_11, R.raw.zangief_12, R.raw.zangief_13, R.raw.zangief_14, R.raw.zangief_15)))

        recyclerView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        val soundBoardAdapter = SoundBoardAdapter()
        recyclerView.adapter = soundBoardAdapter

        val resId: Int = R.anim.grid_layout_animation_from_bottom
        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(this, resId)
        recyclerView.layoutAnimation = animation

        soundBoardAdapter.setList(soundBoardButtons)

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
                            val anim: Animation = AnimationUtils.loadAnimation(gridChild.context, whichAnim)
                            anim.duration = Random.nextLong(250, 750)
                            gridChild.getChildAt(k).startAnimation(anim)
                        }
                    }
                }
            }
        })
    }
}