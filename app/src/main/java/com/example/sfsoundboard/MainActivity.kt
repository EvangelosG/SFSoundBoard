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

class MainActivity : AppCompatActivity() {

    val TAG: String = MainActivity::class.simpleName.toString()
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
        soundBoardButtons.add(SBButton(R.drawable.alex_icon, getString(R.string.Alex), R.raw.alex))
        soundBoardButtons.add(SBButton(R.drawable.balrog_icon, getString(R.string.Balrog), R.raw.balrog))
        soundBoardButtons.add(SBButton(R.drawable.birdie_icon, getString(R.string.Birdie), R.raw.birdie))
        soundBoardButtons.add(SBButton(R.drawable.cammy_icon, getString(R.string.Cammy), R.raw.cammy))
        soundBoardButtons.add(SBButton(R.drawable.chun_icon, getString(R.string.ChunLi), R.raw.chun))
        soundBoardButtons.add(SBButton(R.drawable.dhalsim_icon, getString(R.string.Dhalsim), R.raw.dhalsim))
        soundBoardButtons.add(SBButton(R.drawable.guile_icon, getString(R.string.Guile), R.raw.guile))
        soundBoardButtons.add(SBButton(R.drawable.ibuki_icon, getString(R.string.Ibuki), R.raw.ibuki))
        soundBoardButtons.add(SBButton(R.drawable.karin_icon, getString(R.string.Karin), R.raw.karin))
        soundBoardButtons.add(SBButton(R.drawable.ken_icon, getString(R.string.Ken), R.raw.ken))
        soundBoardButtons.add(SBButton(R.drawable.mika_icon, getString(R.string.Mika), R.raw.mika))
        soundBoardButtons.add(SBButton(R.drawable.nash_icon, getString(R.string.Nash), R.raw.nash))
        soundBoardButtons.add(SBButton(R.drawable.ryu_icon, getString(R.string.Ryu), R.raw.ryu))
        soundBoardButtons.add(SBButton(R.drawable.urien_icon, getString(R.string.Urien), R.raw.urien))
        soundBoardButtons.add(SBButton(R.drawable.vega_icon, getString(R.string.Vega), R.raw.vega))
        soundBoardButtons.add(SBButton(R.drawable.zangief_icon, getString(R.string.Zangief), R.raw.zangief))

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