package com.yashsugandh.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val PENDING_OPERATION = "pendingOperation"
private const val OPERAND_1 = "operand1"

class MainActivity : AppCompatActivity() {
    private lateinit var result: EditText
    private lateinit var newNumber: EditText
    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) { findViewById<TextView>(R.id.result) }

    //Variables that hold operands and calculations.
    private var operand1: Double? = null
    private var pendingOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.operation)
        newNumber = findViewById(R.id.newNumber)

        newNumber.setText("")
        displayOperation.text = ""
        //Value Inputs Buttons
        val button0: Button = findViewById(R.id.button)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDecimal: Button = findViewById(R.id.buttonDecimal)

        //Operations
        val addButton: Button = findViewById(R.id.buttonAdd)
        val subtractButton: Button = findViewById(R.id.buttonSubstract)
        val multiplyButton: Button = findViewById(R.id.buttonMulitply)
        val divideButton: Button = findViewById(R.id.buttonDivide)
        val equalsButton: Button = findViewById(R.id.buttonEquals)

        //OnClick Listener

        val listener = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDecimal.setOnClickListener(listener)

        val opListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            val value = newNumber.text.toString()
            try {
                val value = newNumber.text.toString().toDouble()
                performOperation(value, op)
            } catch (e: NumberFormatException) {
                newNumber.setText("")
            }
            pendingOperation = op
            displayOperation.text = pendingOperation
        }

        equalsButton.setOnClickListener(opListener)
        divideButton.setOnClickListener(opListener)
        multiplyButton.setOnClickListener(opListener)
        addButton.setOnClickListener(opListener)
        subtractButton.setOnClickListener(opListener)
    }

    private fun performOperation(value: Double, operation: String) {
        if (operand1 == null) {
            operand1 = value
        }

        if (pendingOperation == "=") {
            pendingOperation = operation
        }

        when (pendingOperation) {
            "=" -> operand1 = value
            "/" -> operand1 = if (value == 0.0) {
                Double.NaN //Handle attempt to divide by zero
            } else {
                operand1!! / value
            }
            "*" -> operand1 = operand1!! * value
            "-" -> operand1 = operand1!! - value
            "+" -> operand1 = operand1!! + value
        }

        result.setText(operand1.toString())
        newNumber.setText("")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (operand1 != null){
            outState.putDouble(OPERAND_1, operand1!!)
        }
        outState.putString(PENDING_OPERATION, pendingOperation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val operation = savedInstanceState.getString(PENDING_OPERATION)!!
        pendingOperation = operation
        displayOperation.text = operation

        operand1 = savedInstanceState.getDouble(OPERAND_1)
    }
}
