package ru.ftc.di.homework.domain.usecase

import ru.ftc.di.homework.data.repository.SampleStringRepositoryImpl
import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Inject


class GetSampleStringFromLocalUseCase @Inject constructor(
    var repository: SampleStringRepository
) {

    //TODO: DI
    //TODO: сделать так, чтобы repository не пересоздавался для каждого UseCase
    // private val repository: SampleStringRepository = SampleStringRepositoryImpl()

    operator fun invoke(): String {
        val fromLocal = repository.getFromLocal()
        val repoInstanceHash = repository.hashCode()

        return "$fromLocal, repo hash = $repoInstanceHash"
    }
}