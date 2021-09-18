package na.severinchik.data.lesson5

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserDTO(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "age") val age: Int,
    @ColumnInfo(name = "address") val address: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
