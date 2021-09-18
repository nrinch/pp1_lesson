package na.severinchik.lesson5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.data.lesson5.UserDTO
import na.severinchik.data.lesson5.UserRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val userRepository = UserRepository(application)

    private val storage = SimpleStorage(application)

    private val _counter: MutableLiveData<Int> = MutableLiveData()
    val counter: LiveData<Int> = _counter

    private val _users: MutableSharedFlow<List<UserDTO>> = MutableSharedFlow()
    val users: SharedFlow<List<UserDTO>> = _users

    init {
        fetchUsers()
    }

    fun updateCounter() {
        var currentCounter = storage.fetchCount()
        currentCounter += 1
        storage.updateCount(currentCounter)
        _counter.postValue(currentCounter)
    }

    fun fetchCounter() = storage.fetchCount()

    fun reset() = storage.removeCount()

    private fun fetchUsers() {
        viewModelScope.launch {
            userRepository.fetch().collect {
                _users.emit(it)
            }
        }
    }

    fun insertUser(userDTO: UserDTO) {
        viewModelScope.launch {
            userRepository.insert(userDTO)
        }
    }

}