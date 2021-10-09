package na.severinchik.lesson6

import android.app.Application
import na.severinchik.lesson6.data.entity.FoodishApi
import na.severinchik.lesson6.data.repository.FoodishRepository
import na.severinchik.lesson6.domain.FetchImageUseCase
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://foodish-api.herokuapp.com/"

class App : Application() {

    private val logInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logInterceptor)
        .build()

    private val clientRetrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()

    private val apiFoodish = clientRetrofit.create(FoodishApi::class.java)

    private val repository = FoodishRepository(apiFoodish)

    val useCase = FetchImageUseCase(repository)
}