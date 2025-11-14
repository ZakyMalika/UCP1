package com.example.ucp1.View

import android.app.DatePickerDialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulir(onBeranda: () -> Unit,
             modifier: Modifier = Modifier){

    var textMk by remember { mutableStateOf("") }

    var textNamadosen by remember { mutableStateOf("") }
    var textMateri by remember { mutableStateOf("") }
    var textJam by remember { mutableStateOf("")}

    var textAkt by remember { mutableStateOf("")}

    val AktKelas: List<String> = listOf("2023-A", "2023-B","2023-C","2023-D","2023-E")
    val Mteri: List<String> = listOf("Pengembangan Aplikasi Mobile", "Pengembangan Aplilkasi Web","Pengembangan Web Service","Tata Kelola Teknologi Informasi","Manajemen Proyek")
    val Jam: List<String> = listOf("08.50-11.30","13.20-16.20")


    var Mk by remember { mutableStateOf("") }

    var Namadosen by remember { mutableStateOf("") }
    var MTR by remember { mutableStateOf("") }
    var Akt by remember { mutableStateOf("") }
    var Materi by remember { mutableStateOf("") }
    var Jamm by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var expandedMk by remember { mutableStateOf(false) }
    var expandedAkt by remember { mutableStateOf(false) }


    var textTanggal by remember { mutableStateOf("") }

    val context = LocalContext.current

    var Tanggal by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // buat date picker
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                val pickedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                textTanggal = pickedDate
            },
            year, month, day
        )
    }

    var showDialog by remember { mutableStateOf(false) }






    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "FORMULIR PENDAFTARAN PRESENSI")

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, start = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(10.dp)
        ) {

            Column {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color.LightGray)
                        .padding(24.dp)
                ) {

                    Column {
                        Text(
                            text = stringResource(id = R.string.Akt),
                            fontSize = 15.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Box {
                            OutlinedTextField(
                                value = textMk,
                                onValueChange = { textMk = it },
                                label = { Text("Pilih Mata Kuliah") },
                                singleLine = true,
                                shape = MaterialTheme.shapes.large,
                                readOnly = true,
                                modifier = Modifier
                                    .width(350.dp) // <-- Struktur dipertahankan
                                    .clickable { expandedMk = true },
                                trailingIcon = {
                                    IconButton(onClick = { expandedMk = !expandedMk }) {
                                        Icon(
                                            imageVector = if (expandedMk)
                                                Icons.Default.ArrowDropDown
                                            else
                                                Icons.Default.ArrowDropDown,
                                            contentDescription = "Dropdown icon"
                                        )
                                    }
                                }
                            )


                            DropdownMenu(
                                expanded = expandedMk,
                                onDismissRequest = { expandedMk = false },
                                modifier = Modifier.width(350.dp) // <-- Struktur dipertahankan
                            ) {
                                Mteri.forEach { status ->
                                    DropdownMenuItem(
                                        text = { Text(status) },
                                        onClick = {
                                            textMk = status
                                            expandedMk = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Column() {
                            Text(
                                text = "Angkatan-Kelas",
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                            Box {
                                OutlinedTextField(
                                    value = textAkt,
                                    onValueChange = { textAkt = it },
                                    label = { Text("Pilih Angkatan-Kelas") },
                                    singleLine = true,
                                    shape = MaterialTheme.shapes.large,
                                    readOnly = true,
                                    modifier = Modifier
                                        .width(350.dp)
                                        .clickable { expandedAkt = true },
                                    trailingIcon = {
                                        IconButton(onClick = { expandedAkt = !expandedAkt }) {
                                            Icon(
                                                imageVector = if (expandedAkt)
                                                    Icons.Default.ArrowDropDown
                                                else
                                                    Icons.Default.ArrowDropDown,
                                                contentDescription = "Dropdown icon"
                                            )
                                        }
                                    }
                                )

//            untuk Angkatan-Kelas

                                Box {
                                    OutlinedTextField(
                                        value = textAkt,
                                        onValueChange = { textAkt = it },
                                        label = { Text("Pilih Angkatan-Kelas") },
                                        singleLine = true,
                                        shape = MaterialTheme.shapes.large,
                                        readOnly = true,
                                        modifier = Modifier
                                            .width(350.dp)
                                            .clickable { expandedAkt = true },
                                        trailingIcon = {
                                            IconButton(onClick = { expandedAkt = !expandedAkt }) {
                                                Icon(
                                                    imageVector = if (expandedAkt)
                                                        Icons.Default.ArrowDropDown
                                                    else
                                                        Icons.Default.ArrowDropDown,
                                                    contentDescription = "Dropdown icon"
                                                )
                                            }
                                        }
                                    )

                                    DropdownMenu(
                                        expanded = expandedAkt,
                                        onDismissRequest = { expandedAkt = false },
                                        modifier = Modifier
                                            .width(350.dp)

                                    ) {
                                        AktKelas.forEach { status ->
                                            DropdownMenuItem(
                                                text = { Text(status) },
                                                onClick = {
                                                    textAkt = status
                                                    expandedAkt = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }



                        // Tambahkan spacer konsisten antar field
                        Spacer(modifier = Modifier.height(16.dp))

//            date
                        Text(
                            text ="Tanggal",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        // Tambahkan spacer kecil antara label dan field
                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedTextField(
                            value = textTanggal,
                            onValueChange = { },
                            label = { Text("Tanggal ") },
                            readOnly = true,
                            singleLine = true,
                            trailingIcon = {
                                IconButton(onClick = { datePickerDialog.show() }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Pilih tanggal"
                                    )
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp) // <-- Struktur dipertahankan
                                // <--- DIHAPUS: .padding(top = 30.dp) dihapus agar konsisten
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null
                                ) {
                                    datePickerDialog.show()
                                }
                        )

                        Text(
                            text = "Jam",
                            fontSize = 15.sp,
                            color = Color.Black,
                            modifier = Modifier.padding(start = 20.dp,top = 10.dp)
                        )

                        Column {
                            Jam.forEach { item ->
                                Row (
                                    modifier = Modifier.selectable(
                                        selected = textJam == item,
                                        onClick = { textJam = item }
                                    )
                                ) {
                                    RadioButton(selected = textJam == item, onClick = { textJam = item })
                                    Text(item)
                                }
                            }
                        }





                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Nama Dosen",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        // Tambahkan spacer kecil antara label dan field
                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedTextField(
                            value = textNamadosen,
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.width(350.dp), // <-- Struktur dipertahankan
                            label = { Text(text = "Nama Dosen") },
                            onValueChange = { textNamadosen = it }
                        )

                        // Tambahkan spacer konsisten antar field
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Materi",
                            fontSize = 15.sp,
                            color = Color.Black
                        )
                        // Tambahkan spacer kecil antara label dan field
                        Spacer(modifier = Modifier.height(4.dp))

                        OutlinedTextField(
                            value = textMateri,
                            singleLine = true,
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.width(350.dp), // <-- Struktur dipertahankan
                            label = { Text(text = "Materi") },
                            onValueChange = { textMateri = it }
                        )

            }}}}

                Box(Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,

                        ) {
                        Button(
//                            onClick = {  },
                            onClick = onBeranda,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            border = BorderStroke(1.dp, Color.LightGray)
                        ) { Text("Beranda", color = Color.Black) }

                        Button(


                            onClick = {
                                Mk = textMk
                                Akt = textAkt
                                Tanggal = textTanggal
                                Jamm = textJam
                                Namadosen = textNamadosen
                                Materi = textMateri
                                showDialog = true
                            }
                        ) {
                            Text(text = "submit")
                        }

                        if (showDialog) {
                            AlertDialog(
                                onDismissRequest = { showDialog = false },
                                title = {
                                    Text(
                                        text = "Data Registrasi",
                                        fontSize = 22.sp,
                                        color = Color(0xFF3F51B5)
                                    )
                                },
                                text = {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 8.dp)
                                    ) {
                                        Text(
                                            text = "Mata Kuliah:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Mk,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )

                                        Text(
                                            text = "Angkatan-Kelas:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Akt,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )

                                        Text(
                                            text = "Tanggal:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Tanggal,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )
                                        Text(
                                            text = "Jam:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Jamm,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )

                                        Text(
                                            text = "Nama Dosen:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Namadosen,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )

                                        Text(
                                            text = "Materi:",
                                            fontSize = 14.sp,
                                            color = Color.Gray
                                        )
                                        Text(
                                            text = Materi,
                                            fontSize = 16.sp,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )
                                    }
                                },
                                confirmButton = {
                                    Button(
//                                        onClick = {},
                                        onClick = onBeranda,
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.Blue
                                        )
                                    ) {
                                        Text("OK")

                                    }


                                })
                        }


                    }}}}