package na.severinchik.lesson6.data.entity

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface FoodishApi {

    @GET("/api")
    suspend fun fetchRandomFoodImage(): ResponceFoodish
}
