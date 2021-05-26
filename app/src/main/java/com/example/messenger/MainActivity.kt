package com.example.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMsg: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMsg= findViewById(R.id.editTextMessage)

    }

    fun onClickSendMsg(view: View) {
        val msg:String = editTextMsg.text.toString()
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg)
            type = "text/plain"
        }
        val title: String = resources.getString(R.string.chooser_title)
// Интент для запуска окна выбора программы
        val chooser: Intent = Intent.createChooser(sendIntent, title)
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        }

    }
}