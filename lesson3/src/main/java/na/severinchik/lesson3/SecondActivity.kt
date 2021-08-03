package na.severinchik.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    lateinit var finish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        finish = findViewById(R.id.as_finish)

        finish.setOnClickListener { finish() }


    }

    override fun onStart() {
        super.onStart()
        val user = intent.getParcelableExtra<User>(MainActivity.NAME)
        finish.text =  "${user?.name} ${user?.surname}"
    }
}


