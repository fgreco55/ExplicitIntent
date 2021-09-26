package com.example.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.util.Log
import android.view.KeyEvent
import android.view.View
import com.example.explicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var frankbinding: ActivityMainBinding
    private lateinit var sendButton: Button
    private lateinit var inputText: EditText
    companion object {
        const val INPUT_NAME = "NAME_SENT_TO"
    }

// ==================================================================
//  onCreate() - called when Activity starts up
// ==================================================================

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // read the views for this activity into memory
        frankbinding = ActivityMainBinding.inflate(this.layoutInflater)
        
        // show the activity with all its views
        setContentView(frankbinding.root)

        // some convenience variables so I don't have to type the long name...
        sendButton = frankbinding.sendButton
        inputText = frankbinding.inputEdittext

        // Just want to separate the callbacks in a separate area
        addCallbacks()
    }

    // ==================================================================
    // addCallbacks() - all the callbacks for my app are here
    // =================================================================
    fun addCallbacks() {

        // Set the clickListener on the Send button =======================
        sendButton.setOnClickListener { 
            Log.i("MainActivity.addCallbacks", "onClick called")
            
            val name = inputText.getText().toString()
            val myIntent = Intent(this, FrankSecondActivity::class.java)
            myIntent.putExtra(INPUT_NAME, name)
            startActivity(myIntent)
        }

        // Set the KeyListener on the Edittext and look for <CR> =======================
        inputText.setOnKeyListener( object : View.OnKeyListener {
            override fun onKey(myview: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                    Log.i("MainActivity.onKey", "ENTER key pressed")
                    sendButton.performClick()       // performClick() invokes the button callback
                    return true
                } else
                    return false
            }
        })
    }
    
}