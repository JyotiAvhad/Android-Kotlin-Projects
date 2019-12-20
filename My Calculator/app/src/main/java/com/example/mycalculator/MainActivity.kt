package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

// Class declarations and extending AppCompatActivity
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //local variable declaration
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonDot = findViewById<Button>(R.id.buttonDot)
        val buttonAdd = findViewById<Button>(R.id.buttonadd)
        val buttonSub = findViewById<Button>(R.id.buttonsub)
        val buttonMul = findViewById<Button>(R.id.buttonmul)
        val buttonDiv = findViewById<Button>(R.id.buttondiv)
        val buttonMod = findViewById<Button>(R.id.buttonRemainder)
        val buttonEql = findViewById<Button>(R.id.buttoneql)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        //Numbers
        button0.setOnClickListener { appendNumber("0", true) }
        button1.setOnClickListener { appendNumber("1", true) }
        button2.setOnClickListener { appendNumber("2", true) }
        button3.setOnClickListener { appendNumber("3", true) }
        button4.setOnClickListener { appendNumber("4", true) }
        button5.setOnClickListener { appendNumber("5", true) }
        button6.setOnClickListener { appendNumber("6", true) }
        button7.setOnClickListener { appendNumber("7", true) }
        button8.setOnClickListener { appendNumber("8", true) }
        button9.setOnClickListener { appendNumber("9", true) }
        buttonDot.setOnClickListener { appendNumber(".", true) }
        //Operators
        buttonAdd.setOnClickListener { appendNumber("+", false) }
        buttonSub.setOnClickListener { appendNumber("-", false) }
        buttonMul.setOnClickListener { appendNumber("x", false) }
        buttonDiv.setOnClickListener { appendNumber("/", false) }
        buttonMod.setOnClickListener { appendNumber("%", false) }

        buttonEql.setOnClickListener { appendNumber("=", true) }

        buttonClear.setOnClickListener {
            tvOutput.text = ""
            tvOutput.text = ""
        }
        buttonBack.setOnClickListener {
            val string = tvOutput.text.toString()

            if (string.isNotEmpty()) {
                tvOutput.text = string.substring(0, string.length - 1)
            }
            tvInput.text = ""
        }

//        buttonEql.setOnClickListener {
//
//            val text = tvOutput.text.toString()
//            val expression = ExpressionBuilder(text).build()
//
//            val result = expression.evaluate()
//
//            val longResult = result.toLong()
//
//            if (result == longResult.toDouble()) {
//                tvInput.text = longResult.toString()
//            } else {
//                tvInput.text = result.toString()
//            }
//        }
    }

    fun appendNumber(string: String, clear: Boolean) {

        if (clear) {
            tvInput.text = ""
            tvOutput.append(string)
        } else {
            tvOutput.append(tvInput.text)
            tvOutput.append(string)
            tvInput.text = ""
        }
    }

}
