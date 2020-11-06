package com.example.sfsoundboard.viewholders

import android.content.res.Resources
import android.media.MediaPlayer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sfsoundboard.R

import com.example.sfsoundboard.sbkeys.SBButton
import kotlinx.android.synthetic.main.soundboard_item_view.view.*
import java.lang.NullPointerException
import kotlin.random.Random

class SoundBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(button: SBButton, index: Int) {
        Glide.with(itemView.context).load(button.icon).into(itemView.buttonGraphic)

        itemView.setOnClickListener {
            val shake: Animation = AnimationUtils.loadAnimation(itemView.context, R.anim.shake)
            itemView.startAnimation(shake)
            try {
                val rnd: Random = Random(System.currentTimeMillis())
                val player: MediaPlayer? = button.mainSound?.get(rnd.nextInt(0, button.mainSound.size))?.let { it1 -> MediaPlayer.create(itemView.context, it1) }
                player?.start()
                player?.setOnCompletionListener {
                    player.release()
                }
            } catch (e: Resources.NotFoundException) {

            }
        }
        itemView.setOnLongClickListener {
            //TODO launch new activity passing in button
            return@setOnLongClickListener true
        }

    }
}