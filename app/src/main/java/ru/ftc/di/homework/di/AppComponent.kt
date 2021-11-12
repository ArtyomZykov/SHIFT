package ru.ftc.di.homework.di


import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.ftc.di.homework.MainActivity
import ru.ftc.di.homework.data.di.SampleStringDataSourceModule
import ru.ftc.di.homework.domain.di.SampleStringRepositoryModule
import javax.inject.Singleton


@Singleton
@Component(modules = [SampleStringDataSourceModule::class, SampleStringRepositoryModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}