package na.severinchik.data.lesson5

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {
    @Insert
    suspend fun insert(user: UserDTO)

    @Delete
    suspend fun delete(user: UserDTO)

    @Query("SELECT * FROM user_table")
    fun selectAll(): Flow<List<UserDTO>>

    @Query("SELECT * FROM user_table WHERE id LIKE :id")
    suspend fun selectById(id:Int):UserDTO

    @Update
    suspend fun update(user: UserDTO)
}