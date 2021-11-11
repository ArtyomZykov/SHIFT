package ru.ftc.di.homework.data.di

import dagger.Binds
import dagger.Module
import ru.ftc.di.homework.data.datasource.SampleStringDataSource
import ru.ftc.di.homework.data.datasource.SampleStringLocalDataSource
import ru.ftc.di.homework.data.datasource.SampleStringRemoteDataSource
import javax.inject.Named



@Module
abstract class SampleStringDataSourceModule {

    @Binds
    @Named("local")
    abstract fun provideSampleStringLocalDataSource(dataSource: SampleStringLocalDataSource): SampleStringDataSource

    @Binds
    @Named("remote")
    abstract fun provideSampleStringRemoteDataSource(dataSource: SampleStringRemoteDataSource): SampleStringDataSource

}