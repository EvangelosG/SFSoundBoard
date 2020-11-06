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

class SoundBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(button: SBButton, index: Int) {
        Glide.with(itemView.context).load(button.icon).into(itemView.buttonGraphic)

        itemView.setOnClickListener {
            val shake : Animation = AnimationUtils.loadAnimation(itemView.context, R.anim.shake)
            itemView.startAnimation(shake)
            try {
                var player: MediaPlayer = MediaPlayer.create(itemView.context, button.mainSound!!)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            } catch (e: Resources.NotFoundException) {

            } catch (e: NullPointerException) {

            }
        }
    }
}