package com.acidhand.mywallet.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateConverter @Inject constructor() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun provideTime(): String {
        return DateTimeFormatter.ofPattern("HH:mm").format(LocalDateTime.now())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun provideDate(): String {
        val date = DateTimeFormatter.ofPattern("MMM.dd.yyyy").format(LocalDate.now())
        return "$date | ${LocalDate.now().dayOfWeek}"
    }
}
