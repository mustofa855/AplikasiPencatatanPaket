package com.example.aplikasipencatatanpaket.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.aplikasipencatatanpaket.model.DataPaket

@Dao
interface DataPaketDao {
    @Query("SELECT * FROM DataPaket")
    fun loadAll(): LiveData<List<DataPaket>>

    @Query("SELECT * FROM DataPaket WHERE id = :id")
    fun find(id: String): DataPaket?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DataPaket)

    @Delete
    fun delete(item: DataPaket)
}