package com.example.sfsoundboard.viewholders

import android.content.Intent
import android.content.res.Resources
import android.media.MediaPlayer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sfsoundboard.CharacterSoundBoard
import com.example.sfsoundboard.R

import com.example.sfsoundboard.sbkeys.SBButton
import kotlinx.android.synthetic.main.soundboard_item_view.view.*
import kotlin.random.Random

class SoundBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(button: SBButton, index: Int) {
        Glide.with(itemView.context).load(button.icon).into(itemView.buttonGraphic)

        itemView.setOnClickListener {
            val shake: Animation = AnimationUtils.loadAnimation(itemView.context, R.anim.shake)
            itemView.startAnimation(shake)
            try {
                val rnd: Random = Random(System.currentTimeMillis())
                val player: MediaPlayer? = button.sounds?.get(rnd.nextInt(0, button.sounds.size))
                    ?.let { it1 -> MediaPlayer.create(itemView.context, it1) }
                player?.start()
                player?.setOnCompletionListener {
                    player.release()
                }
            } catch (e: Resources.NotFoundException) {

            }
        }
        itemView.setOnLongClickListener {
            val intent = Intent(itemView.context, CharacterSoundBoard::class.java).apply {
                putExtra("button", button)
            }
            itemView.context.startActivity(intent)
            return@setOnLongClickListener true
        }

    }
}