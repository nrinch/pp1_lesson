package na.severinchik.lesson6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.App
import na.severinchik.lesson6.data.ApiResponce

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val useCloseable = (application as App).useCase

    private val _urlImage: MutableSharedFlow<ApiResponce> = MutableSharedFlow()
    val urlImage: SharedFlow<ApiResponce> = _urlImage

    fun fetchNewImage() {
        viewModelScope.launch {
            _urlImage.emit(ApiResponce.Loading)
            _urlImage.emit(useCloseable.fetchImageUrl())
        }
    }
}


/*


Thread (Java) -> Coroutine(1000)



 */