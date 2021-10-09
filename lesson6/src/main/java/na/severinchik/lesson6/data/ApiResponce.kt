package na.severinchik.lesson6.data

sealed class ApiResponce {
    data class Success<T>(val data: T) : ApiResponce()
    object Loading : ApiResponce()
    data class Error(val message: String) : ApiResponce()
}
