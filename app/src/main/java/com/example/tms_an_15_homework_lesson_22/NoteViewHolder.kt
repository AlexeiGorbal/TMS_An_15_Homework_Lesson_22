package com.example.tms_an_15_homework_lesson_22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tms_an_15_homework_lesson_22.databinding.ItemImportantNoteBinding
import com.example.tms_an_15_homework_lesson_22.databinding.ItemNoteBinding

class NoteViewHolder(view: View) : BaseNoteViewHolder(view) {

    private val binding = ItemImportantNoteBinding.bind(view)

    override val title = binding.title
    override val text = binding.text
    override val date = binding.data

    companion object {

        fun from(parent: ViewGroup): NoteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_note, parent, false
            )
            return NoteViewHolder(view)
        }
    }
}