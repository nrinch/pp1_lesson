package na.severinchik.data.lesson5

import android.app.Application
import android.content.Context
import java.util.concurrent.Flow

class UserRepository(application: Application) {
    private val rmDatabase = RmDatabase.getInstance(application.applicationContext)
    private val dao = rmDatabase.userDAO()

    suspend fun insert(userDTO: UserDTO) {
        dao.insert(userDTO)
    }

    fun fetch() = dao.selectAll()
}