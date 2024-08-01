package com.example.mojaposlasticarnica.utils

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.mojaposlasticarnica.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun getCurrentDate(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return dateFormat.format(Date())
}



fun Context.showCustomDialog(message: String) {
    // Inflate the custom layout
    val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null)

    // Create the AlertDialog
    val dialog = AlertDialog.Builder(this)
        .setView(dialogView)
        .create()

    // Set the custom message in the dialog
    val messageTextView: TextView = dialogView.findViewById(R.id.dialog_message)
    messageTextView.text = message

    // Remove the dim background by setting the dimAmount to 0
    dialog.window?.setDimAmount(0f)

    // Show the dialog
    dialog.show()
}

