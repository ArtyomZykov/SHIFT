package ru.ftc.di.homework.domain.di

import dagger.Binds
import dagger.Module
import ru.ftc.di.homework.data.repository.SampleStringRepositoryImpl
import ru.ftc.di.homework.domain.repository.SampleStringRepository
import javax.inject.Singleton

@Module
abstract class SampleStringRepositoryModule {

    @Singleton
    @Binds
    abstract fun repository(dataSource: SampleStringRepositoryImpl): SampleStringRepository

}