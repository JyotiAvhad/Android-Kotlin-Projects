package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.transform.Result

// Class declarations and extending AppCompatActivity
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //local variable declaration
        val tvInput = findViewById<TextView>(R.id.tvInput)
        val tvOutput = findViewById<TextView>(R.id.tvOutput)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
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
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonAllClear = findViewById<Button>(R.id.buttonAllClear)


        button0.setOnClickListener {tvInput.text = "0" }
        button1.setOnClickListener {tvInput.text = "1" }
        button2.setOnClickListener {tvInput.text = "2" }
        button3.setOnClickListener {tvInput.text = "3" }
        button4.setOnClickListener {tvInput.text = "4" }
        button5.setOnClickListener {tvInput.text = "5" }
        button6.setOnClickListener {tvInput.text = "6" }
        button7.setOnClickListener {tvInput.text = "7" }
        button8.setOnClickListener {tvInput.text = "8" }
        button9.setOnClickListener {tvInput.text = "9" }
        buttonDot.setOnClickListener {tvInput.text = "." }
        buttonAdd.setOnClickListener {tvInput.text = "+" }
        buttonSub.setOnClickListener {tvInput.text = "-" }
        buttonMul.setOnClickListener {tvInput.text = "x" }
        buttonDiv.setOnClickListener {tvInput.text = "/" }
        buttonMod.setOnClickListener {tvInput.text = "%" }
        buttonEql.setOnClickListener {tvInput.text = "=" }
        buttonClear.setOnClickListener {tvInput.text = " " }
        buttonAllClear.setOnClickListener {tvInput.text = " " }

    }

    fun appendNumber(string:String,clear:Boolean){

        if(clear){
            tvInput.text=""
            tvOutput.append(string)
        }else{
            tvOutput.append(tvInput.text)
            tvOutput.append(string)
            tvInput.text=""
        }
    }

}
