package com.example.tms_an_15_homework_lesson_22

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.SimpleDateFormat

abstract class BaseNoteViewHolder(view: View) : ViewHolder(view) {

    protected abstract val title: AppCompatTextView
    protected abstract val text: AppCompatTextView
    protected abstract val date: AppCompatTextView

    private val formatter = SimpleDateFormat("hh:mm dd.MM.yyyy")

    fun bind(note: BaseNote, onItemClick: (BaseNote) -> Unit) {
        title.text = note.title
        text.text = note.text
        date.text = formatter.format(note.date)
        itemView.setOnClickListener {
            onItemClick(note)
        }
    }
}