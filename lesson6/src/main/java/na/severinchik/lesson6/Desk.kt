package na.severinchik.lesson6

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class FirstActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Intent(this, SecondActivity::class.java).apply {
            putExtra("KEY1", "Hola")
            startActivity(this)
        }

        Intent(Intent.ACTION_CALL)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("themeColors", "Red")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val color = savedInstanceState.getString("themeColors")
    }
}

class SecondActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val result = intent.getStringExtra("KEY1")
    }
}