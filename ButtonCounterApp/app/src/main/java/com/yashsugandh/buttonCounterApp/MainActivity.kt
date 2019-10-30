package com.yashsugandh.buttonCounterApp

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"
private const val TEXT_CONTENT = "TextContent"
private const val BUTTON_COUNTER = "ButtonCounter"

class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null
private var numberOfTimesButtonClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate method called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTab = findViewById<EditText>(R.id.name_tab)
        nameTab.text.clear()
        val nameButton = findViewById<Button>((R.id.btn_name))
        textView = findViewById(R.id.text_view)

        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()

        nameButton?.setOnClickListener {
            Log.d(TAG, "onClick method called")
            numberOfTimesButtonClicked += 1

            textView?.append("Name added $numberOfTimesButtonClicked.${nameTab.text} \n")
            nameTab.text.clear()
        }

    }

    override fun onResume() {
        Log.d(TAG, "onResume method called")
        super.onResume()
    }

    override fun onStart() {
        Log.d(TAG, "onStart method called")
        super.onStart()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart method called")
        super.onRestart()
    }

    override fun onPause() {
        Log.d(TAG, "onPause method called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop method called")
        super.onStop()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState method called")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENT, "")
        numberOfTimesButtonClicked = savedInstanceState?.getInt(BUTTON_COUNTER)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy method called")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState method called")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENT, textView?.text.toString())
        outState.putInt(BUTTON_COUNTER,numberOfTimesButtonClicked)
    }

}
