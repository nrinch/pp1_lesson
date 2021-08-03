package na.severinchik.lesson2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var title_TV: TextView
    lateinit var image: ImageView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializationViews()

        button.setOnClickListener { v ->
            val button = v as Button
            button.text = getString(R.string.clicked)
            image.visibility = View.INVISIBLE
            title_TV.text = "${title_TV.text} and Bobr!"
        }
    }


    private fun initializationViews() {
        title_TV = findViewById(R.id.am_title)
        image = findViewById(R.id.am_image_bobr)
        button = findViewById(R.id.am_button_press_me)
    }
}