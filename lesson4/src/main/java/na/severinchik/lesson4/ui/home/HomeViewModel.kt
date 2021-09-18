package na.severinchik.lesson4.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val storage = StorageImpl()


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun emitNewData(value: String) {
        _text.postValue(value)
    }

    fun fetchData(){

        //delay

        _text.postValue(
            storage.fetchSomeData()
        )
    }
}


interface Storage {
    fun fetchSomeData(): String
}

class StorageImpl : Storage {
    override fun fetchSomeData(): String {
        TODO("Not yet implemented")
    }

}