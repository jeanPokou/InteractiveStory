package com.example.jeanpokou.interactivestory.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import com.example.jeanpokou.interactivestory.R
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.editText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       startButton.setOnClickListener({
           //toast(message = nameEditText.text)
           startActivity(intentFor<StoryActivity>(params = R.string.key_name.toString().to(that = nameEditText.text.toString())))
       })


    }

    override fun onResume() {
        super.onResume()

        nameEditText.setText("")
    }

}
