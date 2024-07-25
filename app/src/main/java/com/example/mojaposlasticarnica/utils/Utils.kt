package com.example.mojaposlasticarnica.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormat.format(Date())
}
