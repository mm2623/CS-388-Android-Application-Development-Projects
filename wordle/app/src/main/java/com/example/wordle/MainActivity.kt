package com.example.wordle

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var counter = 0
        val simpleEditText = findViewById<View>(R.id.inputtext) as EditText
        val randomword = getRandomFourLetterWord() // Random word generated
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView4 = findViewById<TextView>(R.id.textView4)
        val textView6 = findViewById<TextView>(R.id.textView6)
        val textView8 = findViewById<TextView>(R.id.textView8)
        val textView10 = findViewById<TextView>(R.id.textView10)
        val textView12 = findViewById<TextView>(R.id.textView12)
        textView2.visibility = View.GONE
        textView4.visibility = View.GONE
        textView6.visibility = View.GONE
        textView8.visibility = View.GONE
        textView10.visibility = View.GONE
        textView12.visibility = View.GONE
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView7 = findViewById<TextView>(R.id.textView7)
        val textView9 = findViewById<TextView>(R.id.textView9)
        val textView11 = findViewById<TextView>(R.id.textView11)
        val textView13 = findViewById<TextView>(R.id.textView13)
        textView3.visibility = View.GONE
        textView5.visibility = View.GONE
        textView7.visibility = View.GONE
        textView9.visibility = View.GONE
        textView11.visibility = View.GONE
        textView13.visibility = View.GONE
        val textView = findViewById<TextView>(R.id.textView)
        textView.visibility = View.GONE
        val resetbutton = findViewById<Button>(R.id.resetbutton)
        resetbutton.visibility = View.GONE
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            val strValue = simpleEditText.text.toString()
            val pat = "[a-zA-Z]+"
            if(strValue.length == 4 && strValue.matches(pat.toRegex())) {
                if (counter < 3) {
                    val uppercase = strValue.uppercase()
                    val result = checkGuess(uppercase, randomword)
                    if (counter == 0) {
                        textView3.text = uppercase
                        textView5.text = result
                        textView2.visibility = View.VISIBLE
                        textView3.visibility = View.VISIBLE
                        textView4.visibility = View.VISIBLE
                        textView5.visibility = View.VISIBLE
                    }
                    if (counter == 1) {
                        textView7.text = uppercase
                        textView9.text = result
                        textView6.visibility = View.VISIBLE
                        textView7.visibility = View.VISIBLE
                        textView8.visibility = View.VISIBLE
                        textView9.visibility = View.VISIBLE
                    }
                    if (counter == 2) {
                        textView11.text = uppercase
                        textView13.text = result
                        textView10.visibility = View.VISIBLE
                        textView11.visibility = View.VISIBLE
                        textView12.visibility = View.VISIBLE
                        textView13.visibility = View.VISIBLE
                        textView.text = randomword
                        textView.visibility = View.VISIBLE
                        // Disable edit box and guss button
                        button.visibility = View.GONE
                        simpleEditText.visibility = View.GONE
                    }
                    simpleEditText.text = null
                    counter++
                }
                if (counter > 2) {
                    resetbutton.visibility = View.VISIBLE

                }
            }
            if (strValue.length != 4){
                val l = strValue.length
                Toast.makeText(this, "ERROR. You have enter $l letters. You need to enter 4 letters", Toast.LENGTH_SHORT).show()
            }
            if (!strValue.matches(pat.toRegex())){
                Toast.makeText(this, "ERROR. You have enter characters that are not alphabetical (A-Z)", Toast.LENGTH_SHORT).show()
            }

        }
        resetbutton.setOnClickListener{
            recreate()
        }
    }
    private fun checkGuess(guess: String, randomword: String) : Spannable{
//        val result = ""

        val spannable: Spannable = SpannableString(guess)
        for (i in 0..3) {
            if (guess[i] == randomword[i]) {
//                result += "O"
                spannable.setSpan(ForegroundColorSpan(Color.GREEN), i,i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            else if (guess[i] in randomword) {
//                result += "+"
                spannable.setSpan(ForegroundColorSpan(Color.BLUE), i,i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            else {
//                result += "X"
                spannable.setSpan(ForegroundColorSpan(Color.RED), i,i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
        return spannable
    }
}

