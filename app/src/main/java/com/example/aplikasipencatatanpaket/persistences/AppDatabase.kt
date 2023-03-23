package com.example.aplikasipencatatanpaket.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplikasipencatatanpaket.model.DataPaket

@Database(entities = [DataPaket::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataPaketDao(): DataPaketDao
}