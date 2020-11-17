package com.example.sfsoundboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sfsoundboard.R
import com.example.sfsoundboard.sbkeys.SBButton
import com.example.sfsoundboard.viewholders.CharacterBoardViewHolder

class CharacterSoundBoardAdapter : RecyclerView.Adapter<CharacterBoardViewHolder>() {

    private lateinit var button : SBButton

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterBoardViewHolder {
        return CharacterBoardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.character_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterBoardViewHolder, position: Int) {
        holder.bindView(button, position)
    }

    override fun getItemCount(): Int {
        return button.sounds!!.size
    }

    fun setButton(button: SBButton?) {
        if (button != null) {
            this.button = button
        }
    }
}
