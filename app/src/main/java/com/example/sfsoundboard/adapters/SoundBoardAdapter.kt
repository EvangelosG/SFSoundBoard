package com.example.sfsoundboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sfsoundboard.R
import com.example.sfsoundboard.sbkeys.SBButton
import com.example.sfsoundboard.viewholders.SoundBoardViewHolder

class SoundBoardAdapter : RecyclerView.Adapter<SoundBoardViewHolder>() {

    private var list = listOf<SBButton>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundBoardViewHolder {
        return SoundBoardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.soundboard_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SoundBoardViewHolder, position: Int) {
        holder.bindView(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(list: List<SBButton>) {
        this.list = list
    }

}