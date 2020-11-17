package com.example.sfsoundboard.viewholders


import android.content.res.Resources
import android.media.MediaPlayer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.sfsoundboard.R
import com.example.sfsoundboard.sbkeys.SBButton
import kotlinx.android.synthetic.main.character_item_view.view.*

class CharacterBoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView(button: SBButton, index: Int) {
        itemView.buttonText?.text = index.toString()
        itemView.buttonText2.text = index.toString()

        itemView.setOnClickListener {
            val shake: Animation = AnimationUtils.loadAnimation(itemView.context, R.anim.shake)
            itemView.startAnimation(shake)
            try {
                val player: MediaPlayer? = button.sounds?.get(index)?.let { it1 -> MediaPlayer.create(itemView.context, it1) }
                player?.start()
                player?.setOnCompletionListener {
                    player.release()
                }
            } catch (e: Resources.NotFoundException) {

            }
        }
    }
}