package com.example.aplikasipencatatanpaket.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.aplikasipencatatanpaket.model.DataPaket
import com.example.aplikasipencatatanpaket.persistences.AppDatabase

@Composable
fun PengelolaanPaketScreen() {
    val viewModel = hiltViewModel<PengelolaanPaketViewModel>()
    val items: List<DataPaket> by viewModel.list.observeAsState(initial =
    listOf())


    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanPaket()
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "No Resi", fontSize = 14.sp)
                        Text(text = item.noResi, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama Barang", fontSize = 14.sp)
                        Text(text = item.namaBrg, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal Terima", fontSize = 14.sp)
                        Text(text = item.tglTerima, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Pengirim", fontSize = 14.sp)
                        Text(text = item.pengirim, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}