package com.example.arnavjha.newone

import android.content.Context
import android.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.GONE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*
import com.example.arnavjha.newone.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

     lateinit var rollButton:Button
    lateinit var doneButton:Button
    lateinit var enterName:EditText
    lateinit var displayName:TextView
   private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


         rollButton = binding.Click
        rollButton.setOnClickListener{rollDice()}
        references()
        doneButton.setOnClickListener(){
            onClickEvent(it)
        }

        displayName.setOnClickListener(){
            updateName(it)
        }
    }

    private fun updateName(view: View) {
doneButton.visibility = View.VISIBLE
        enterName.visibility = View.VISIBLE
        displayName.visibility = GONE
        enterName.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(enterName, 0)
    }

    private fun rollDice(){
        val result:TextView = findViewById(R.id.tvDisplay)
        val int = Random().nextInt(6)+1
        result.text = int.toString()
    }

    private fun references(){
      doneButton = binding.btDone
        enterName = binding.etName
        displayName = binding.tvName

    }

    private fun onClickEvent(view: View) {
        displayName.text = enterName.text
        enterName.visibility = GONE
        doneButton.visibility = GONE
        displayName.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }
}


