package na.severinchik.lesson3

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {

    lateinit var edittext: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edittext = findViewById(R.id.am_input_field)
    }

    fun goToAnotherActivity(view: View) {
        val user = User("Jonh", "Wallker")
        val user2 = user.copy(name = "Peter")
        val intent = Intent(this, SecondActivity::class.java)
        if (edittext.text.isNotEmpty()) {
        }
        intent.putExtra(NAME, user)
        startActivity(intent)

    }

    companion object {
        const val NAME = "NAME"
    }
}

@Parcelize
data class User(val name: String, val surname: String) : Parcelable

