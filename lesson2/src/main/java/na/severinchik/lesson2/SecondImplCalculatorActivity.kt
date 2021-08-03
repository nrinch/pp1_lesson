package na.severinchik.lesson2

import android.os.Bundle
import android.view.View
import android.widget.EdgeEffect
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondImplCalculatorActivity : AppCompatActivity() {

    var buffer_Operator: String = ""
    var argument1: Int = 0
    var argument2: Int = 0

    lateinit var outputTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_impl_calculator)
        outputTextView = findViewById(R.id.acs_output_text_view)
    }

    fun enterNumber(view: View) {
        when (view.id) {
            R.id.acs_button_number_0 -> outputTextView.text = "${outputTextView.text}0"
            R.id.acs_button_number_1 -> outputTextView.text = "${outputTextView.text}1"
            R.id.acs_button_number_2 -> outputTextView.text = "${outputTextView.text}2"
            R.id.acs_button_number_3 -> outputTextView.text = "${outputTextView.text}3"
            R.id.acs_button_number_4 -> outputTextView.text = "${outputTextView.text}4"
            R.id.acs_button_number_5 -> outputTextView.text = "${outputTextView.text}5"
            R.id.acs_button_number_6 -> outputTextView.text = "${outputTextView.text}6"
            R.id.acs_button_number_7 -> outputTextView.text = "${outputTextView.text}7"
            R.id.acs_button_number_8 -> outputTextView.text = "${outputTextView.text}8"
            R.id.acs_button_number_9 -> outputTextView.text = "${outputTextView.text}9"
        }
    }

    fun operation(view: View) {
        when (view.id) {
            R.id.acs_button_clear -> outputTextView.text = calc()

            R.id.acs_button_div -> setOperator("/")
            R.id.acs_button_minus -> setOperator("-")
            R.id.acs_button_mult -> setOperator("*")
            R.id.acs_button_plus -> setOperator("+")
        }
    }


    private fun setOperator(operator: String) {
        buffer_Operator = operator
        argument1 = outputTextView.text.toString().toInt()
        outputTextView.text = ""
    }

    private fun calc(): String {
        argument2 = outputTextView.text.toString().toInt()
        when (buffer_Operator) {
            "+" -> return (argument1 + argument2).toString()
            "-" -> return (argument1 - argument2).toString()
            "*" -> return (argument1 * argument2).toString()
            "/" -> return (argument1 / argument2).toString()
        }
        return String.EMPTY()
    }

}