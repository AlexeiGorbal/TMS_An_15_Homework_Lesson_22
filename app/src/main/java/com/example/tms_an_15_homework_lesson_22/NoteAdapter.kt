package com.example.tms_an_15_homework_lesson_22

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class NoteAdapter(private val onItemClick: (BaseNote) -> Unit) : Adapter<BaseNoteViewHolder>() {

    private val list = mutableListOf<BaseNote>()

    fun addNote(note: BaseNote) {
        list.add(note)
        notifyItemInserted(list.lastIndex)
    }

    override fun getItemViewType(position: Int): Int {
        return if (list[position] is Note) {
            NOTE_TYPE
        } else {
            IMPORTANT_NOTE_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseNoteViewHolder {
        return if (viewType == NOTE_TYPE) {
            NoteViewHolder.from(parent)
        } else {
            ImportantNoteViewHolder.from(parent)
        }
    }

    override fun onBindViewHolder(holder: BaseNoteViewHolder, position: Int) {
        holder.bind(list[position], onItemClick)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    companion object {
        private const val NOTE_TYPE = 1
        private const val IMPORTANT_NOTE_TYPE = 2
    }
}