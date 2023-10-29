package com.example.tms_an_15_homework_lesson_22

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
class ImportantNote(
    override val title: String,
    override val text: String,
    override val date: Date
) : Parcelable, BaseNote(title, text, date)