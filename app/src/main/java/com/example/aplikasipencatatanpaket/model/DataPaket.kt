package com.example.aplikasipencatatanpaket.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataPaket(
    @PrimaryKey val id: String,
    val noResi: String,
    val namaBrg: String,
    val tglTerima: String,
    val pengirim: String
)