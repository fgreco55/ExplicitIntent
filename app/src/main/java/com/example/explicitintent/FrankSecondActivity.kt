package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.explicitintent.databinding.ActivityFrankSecondBinding

class FrankSecondActivity : AppCompatActivity() {
    private lateinit var frankbinding: ActivityFrankSecondBinding
    private lateinit var msgText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        frankbinding = ActivityFrankSecondBinding.inflate(this.layoutInflater)
        setContentView(frankbinding.root)

        msgText = frankbinding.msgText

        val myIntent = getIntent()
        val msg = myIntent.getStringExtra(MainActivity.INPUT_NAME)
        msgText.setText(msg)
    }
}