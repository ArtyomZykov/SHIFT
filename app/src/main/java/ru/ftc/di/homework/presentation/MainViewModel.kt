package ru.ftc.di.homework.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.ftc.di.homework.domain.usecase.GetSampleStringFromLocalUseCase
import ru.ftc.di.homework.domain.usecase.GetSampleStringFromRemoteUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getSampleStringFromLocalUseCase: GetSampleStringFromLocalUseCase,
    val getSampleStringFromRemoteUseCase: GetSampleStringFromRemoteUseCase
) {
    //TODO: DI
    // private val getSampleStringFromLocalUseCase = GetSampleStringFromLocalUseCase()
    // private val getSampleStringFromRemoteUseCase = GetSampleStringFromRemoteUseCase()

    private val _state: MutableLiveData<MainState> = MutableLiveData<MainState>()
    val state: LiveData<MainState> = _state

    fun loadStrings() {
        _state.value = MainState.Loading

        val fromLocal = getSampleStringFromLocalUseCase()
        val fromRemote = getSampleStringFromRemoteUseCase()

        _state.value = MainState.Success(remoteString = fromRemote, localString = fromLocal)
    }
}