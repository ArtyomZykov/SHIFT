package com.example.savestate.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.savestate.data.model.PhoneItem
import com.example.savestate.data.room.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainFragmentViewModel(private val repository: RoomRepository) : ViewModel() {
    val allNotes: LiveData<List<PhoneItem>> = repository.allNotes.asLiveData()


    fun insert(word: PhoneItem) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteAll()
    }

}

class MainFragmentModelFactory(private val repository: RoomRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainFragmentViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
