package na.severinchik.lesson6.domain

import na.severinchik.lesson6.data.ApiResponce
import na.severinchik.lesson6.data.repository.FoodishRepository

class FetchImageUseCase(private val repository: FoodishRepository) {

    suspend fun fetchImageUrl(): ApiResponce =
        repository.fetchRandomImage()

}