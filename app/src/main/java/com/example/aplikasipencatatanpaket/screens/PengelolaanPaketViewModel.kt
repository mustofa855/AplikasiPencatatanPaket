package com.example.aplikasipencatatanpaket.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.aplikasipencatatanpaket.model.DataPaket
import com.example.aplikasipencatatanpaket.persistences.DataPaketDao
import javax.inject.Inject

@HiltViewModel
class PengelolaanPaketViewModel @Inject constructor(private val
                                                    dataPaketDao: DataPaketDao) : ViewModel() {
    val list : LiveData<List<DataPaket>> = dataPaketDao.loadAll()
    suspend fun insert(id: String,
                       noResi: String,
                       namaBrg: String,
                       tglTerima: String,
                       pengirim: String){
        val item = DataPaket(id, noResi, namaBrg, tglTerima, pengirim)
        dataPaketDao.insertAll(item)
    }
}
