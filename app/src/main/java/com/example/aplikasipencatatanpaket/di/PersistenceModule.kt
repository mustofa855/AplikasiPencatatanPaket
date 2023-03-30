package com.example.aplikasipencatatanpaket.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.aplikasipencatatanpaket.persistences.AppDatabase
import com.example.aplikasipencatatanpaket.persistences.DataPaketDao
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "pengelolaan-paket"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSetoranSampahDao(appDatabase: AppDatabase): DataPaketDao {
        return appDatabase.dataPaketDao()
    }
}