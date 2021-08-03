package na.severinchik.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    lateinit var outputTextView: TextView
    lateinit var btnNumber1: Button
    lateinit var btnNumber2: Button
    lateinit var btnNumber3: Button
    lateinit var btnNumber4: Button
    lateinit var btnNumber5: Button
    lateinit var btnNumber6: Button
    lateinit var btnNumber7: Button
    lateinit var btnNumber8: Button
    lateinit var btnNumber9: Button
    lateinit var btnNumber0: Button

    lateinit var btnPlus: Button
    lateinit var btnMinus: Button
    lateinit var btnMult: Button
    lateinit var btnDiv: Button

    lateinit var btnEqual: Button
    lateinit var btnClear: Button

    var operator: String = ""
    var argument1: Int = 0
    var argument2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initializeView()
        setListeneres()

    }

    val numberClickListener = View.OnClickListener {
        when ((it as Button).text) {
            "1" -> outputTextView.text = "${outputTextView.text}1"
            "2" -> outputTextView.text = "${outputTextView.text}2"
            "3" -> outputTextView.text = "${outputTextView.text}3"
            "4" -> outputTextView.text = "${outputTextView.text}4"
            "5" -> outputTextView.text = "${outputTextView.text}5"
            "6" -> outputTextView.text = "${outputTextView.text}6"
            "7" -> outputTextView.text = "${outputTextView.text}7"
            "8" -> outputTextView.text = "${outputTextView.text}8"
            "9" -> outputTextView.text = "${outputTextView.text}9"
            "0" -> outputTextView.text = "${outputTextView.text}0"
        }
    }

    val operationClickListener = View.OnClickListener {
        when ((it as Button).text) {
            "+" -> operator = "+"
            "-" -> operator = "-"
            "*" -> operator = "*"
            "/" -> operator = "/"
        }

        argument1 = outputTextView.text.toString().toInt()
        outputTextView.text = ""
    }

    fun setListeneres() {
        btnNumber0.setOnClickListener(numberClickListener)
        btnNumber1.setOnClickListener(numberClickListener)
        btnNumber2.setOnClickListener(numberClickListener)
        btnNumber3.setOnClickListener(numberClickListener)
        btnNumber4.setOnClickListener(numberClickListener)
        btnNumber5.setOnClickListener(numberClickListener)
        btnNumber6.setOnClickListener(numberClickListener)
        btnNumber7.setOnClickListener(numberClickListener)
        btnNumber8.setOnClickListener(numberClickListener)
        btnNumber9.setOnClickListener(numberClickListener)

        btnPlus.setOnClickListener(operationClickListener)
        btnMinus.setOnClickListener(operationClickListener)
        btnMult.setOnClickListener(operationClickListener)
        btnDiv.setOnClickListener(operationClickListener)

        btnClear.setOnClickListener {
            operator = String.EMPTY()
            outputTextView.text = String.EMPTY()
            argument1 = 0
            argument2 = 0
        }

        btnEqual.setOnClickListener {
            outputTextView.text = calc()
        }
    }

    fun calc(): String {
        argument2 = outputTextView.text.toString().toInt()
        when (operator) {
            "+" -> return (argument1 + argument2).toString()
            "-" -> return (argument1 - argument2).toString()
            "*" -> return (argument1 * argument2).toString()
            "/" -> return (argument1 / argument2).toString()
        }
        return String.EMPTY()
    }

    fun initializeView() {

        outputTextView = findViewById(R.id.ac_output_text_view)
        btnNumber0 = findViewById(R.id.button_number_0)
        btnNumber1 = findViewById(R.id.button_number_1)
        btnNumber2 = findViewById(R.id.button_number_2)
        btnNumber3 = findViewById(R.id.button_number_3)
        btnNumber4 = findViewById(R.id.button_number_4)
        btnNumber5 = findViewById(R.id.button_number_5)
        btnNumber6 = findViewById(R.id.button_number_6)
        btnNumber7 = findViewById(R.id.button_number_7)
        btnNumber8 = findViewById(R.id.button_number_8)
        btnNumber9 = findViewById(R.id.button_number_9)

        btnClear = findViewById(R.id.ac_button_clear)
        btnEqual = findViewById(R.id.button_equal)

        btnPlus = findViewById(R.id.ac_button_plus)
        btnMinus = findViewById(R.id.ac_button_minus)
        btnMult = findViewById(R.id.ac_button_mult)
        btnDiv = findViewById(R.id.ac_button_div)

    }

    fun number(view: View) {}
}

fun String.Companion.EMPTY() = ""