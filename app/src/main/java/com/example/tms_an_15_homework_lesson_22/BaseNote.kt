package com.example.tms_an_15_homework_lesson_22

import java.util.Date

sealed class BaseNote(open val title: String, open val text: String, open val date: Date)