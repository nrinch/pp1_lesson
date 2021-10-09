package na.severinchik.lesson6.data.repository

import na.severinchik.lesson6.data.ApiResponce
import na.severinchik.lesson6.data.entity.FoodishApi
import na.severinchik.lesson6.data.entity.ResponceFoodish
import java.lang.Error

class FoodishRepository(private val api: FoodishApi) {

    suspend fun fetchRandomImage(): ApiResponce {
        return try {
            val result = api.fetchRandomFoodImage()
            ApiResponce.Success(data = result)

        } catch (error: Error) {
            ApiResponce.Error(error.message.toString())
        }
    }
}