package na.severinchik.lesson6.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleSerializationResponce(
    @SerialName(value = "user_id")
    val id: Long,
    @SerialName(value = "nickname")
    val name: String,
    @SerialName(value = "surname")
    val familyName: String
)

