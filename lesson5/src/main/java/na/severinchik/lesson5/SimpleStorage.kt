package na.severinchik.lesson5

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

private const val SIMPLE_STORAGE = "simple_storage"

private const val COUNT_KEY = "count_key"
private const val COUNT_DEFAULT_VALUE: Int = 0


class SimpleStorage(application: Application) {
    private val sharedPreferences =
        application.getSharedPreferences(SIMPLE_STORAGE, Context.MODE_PRIVATE)

    private val editor = sharedPreferences.edit()

    fun updateCount(count: Int) {
        editor.putInt(COUNT_KEY, count)
        editor.commit()
    }

    fun fetchCount(): Int = sharedPreferences.getInt(COUNT_KEY, COUNT_DEFAULT_VALUE)

    fun removeCount() = editor.remove(COUNT_KEY)

    fun clear() = editor.clear().commit()
}