package com.example.aplikasipencatatanpaket.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.aplikasipencatatanpaket.model.DataPaket
import com.example.aplikasipencatatanpaket.persistences.DataPaketDao
import com.example.aplikasipencatatanpaket.ui.theme.Purple700
import com.example.aplikasipencatatanpaket.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanPaket(dataPaketDao: DataPaketDao) {
    val scope = rememberCoroutineScope()
    val noResi = remember { mutableStateOf(TextFieldValue("")) }
    val namaBrg = remember { mutableStateOf(TextFieldValue("")) }
    val tglTerima = remember { mutableStateOf(TextFieldValue("")) }
    val pengirim = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "No Resi") },
            value = noResi.value,
            onValueChange = {
                noResi.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "12345678") }
        )

        OutlinedTextField(
            label = { Text(text = "Nama Barang") },
            value = namaBrg.value,
            onValueChange = {
                namaBrg.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "XXXXX") }
        )

        OutlinedTextField(
            label = { Text(text = "Tanggal Terima") },
            value = tglTerima.value,
            onValueChange = {
                tglTerima.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "hh-bb-tttt") }
        )
        OutlinedTextField(
            label = { Text(text = "Pengirim") },
            value = pengirim.value,
            onValueChange = {
                pengirim.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Text),
            placeholder = { Text(text = "xxxxxx") }
        )

        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )

        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()

                val item = DataPaket(id, noResi.value.text, namaBrg.value.text,
                    tglTerima.value.text, pengirim.value.text)
                scope.launch {
                dataPaketDao.insertAll(item)
                }
                noResi.value = TextFieldValue("")
                namaBrg.value = TextFieldValue("")
                tglTerima.value = TextFieldValue("")
                pengirim.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                noResi.value = TextFieldValue("")
                namaBrg.value = TextFieldValue("")
                tglTerima.value = TextFieldValue("")
                pengirim.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}




