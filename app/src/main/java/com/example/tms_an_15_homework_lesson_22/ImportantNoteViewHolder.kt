package com.example.tms_an_15_homework_lesson_22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.example.tms_an_15_homework_lesson_22.databinding.ItemImportantNoteBinding

class ImportantNoteViewHolder(view: View) : BaseNoteViewHolder(view) {

    private val binding = ItemImportantNoteBinding.bind(view)

    override val title = binding.title
    override val text = binding.text
    override val date = binding.data

    companion object {

        fun from(parent: ViewGroup): ImportantNoteViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_important_note, parent, false
            )
            return ImportantNoteViewHolder(view)
        }
    }
}