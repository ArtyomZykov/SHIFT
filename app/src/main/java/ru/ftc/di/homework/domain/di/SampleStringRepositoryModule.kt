package ru.ftc.di.homework.domain.di

import dagger.Binds
import dagger.Module
import ru.ftc.di.homework.data.repository.SampleStringRepositoryImpl
import ru.ftc.di.homework.domain.repository.SampleStringRepository

@Module
abstract class SampleStringRepositoryModule {

    @Binds
    abstract fun repository(dataSource: SampleStringRepositoryImpl): SampleStringRepository

}