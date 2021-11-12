package ru.ftc.di.homework.domain.usecase

import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject


class GetSampleStringFromRemoteUseCase @Inject constructor(
    val repository: SampleStringRepository
) {
    operator fun invoke(): String {
        val fromRemote = repository.getFromRemote()
        val repoInstanceHash = repository.hashCode()

        return "$fromRemote, repo hash = $repoInstanceHash"
    }
}