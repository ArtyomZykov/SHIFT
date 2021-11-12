package ru.ftc.di.homework.domain.usecase

import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject


class GetSampleStringFromLocalUseCase @Inject constructor(
    var repository: SampleStringRepository
) {
    operator fun invoke(): String {
        val fromLocal = repository.getFromLocal()
        val repoInstanceHash = repository.hashCode()

        return "$fromLocal, repo hash = $repoInstanceHash"
    }
}