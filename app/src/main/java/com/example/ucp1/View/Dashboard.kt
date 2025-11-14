package com.example.ucp1.View

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(onBeranda: () -> Unit,
              onForm: () -> Unit,
              modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(false)



    }
    data class CardData(
        val MataKuliah: String,
        val Angkatan: String,
        val Kelas: String
    )

    val allBiodata = listOf(
        CardData(
            MataKuliah = "Pengembangan Aplikasi Mobile",
            Angkatan = "2023",
            Kelas = "B"
        ),
        CardData(
            MataKuliah = "Pengembangan Aplikasi Web",
            Angkatan = "2023",
            Kelas = "A"
        ),
        CardData(
            MataKuliah = "Pengembangan Web Service",
            Angkatan = "2023",
            Kelas = "C"
        ),
        CardData(
            MataKuliah = "Tata Kelola Teknologi Informasi",
            Angkatan = "2023",
            Kelas = "D"
        ),
        CardData(
            MataKuliah = "Manajemen Proyek",
            Angkatan = "2023",
            Kelas = "A"
        ),

        )

    Scaffold (
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth()
//                        horizontalArrangement = Arrangement.Center
                    ) {
                        val gambar1 = painterResource(id = R.drawable.logo)
                        Image(
                            painter = gambar1,
                            contentDescription = null,
                            modifier = Modifier
                                .size(size = 80.dp)
                                .padding(all = 1.dp)
                                .clip(RoundedCornerShape(1000.dp))

                        )

                        Column() {
                            Text(text = "Muhammad Zaky Malika")
                            Text(text = "20230140017")
                        }
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_200))
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = colorResource(id = R.color.purple_200),
            ) {
                Row(modifier = Modifier.padding(start = 50.dp)) {
                    Button(
//                        onClick = {},
                    onClick = onBeranda,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        border = BorderStroke(1.dp, Color.LightGray)
                    ) { Text("Logout", color = Color.Black) }

            Spacer(modifier = Modifier


                .width(100.dp),
                )
                                Button(
//                                    onClick = {},
                                onClick = onForm,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    border = BorderStroke(1.dp, Color.LightGray)
                                ) { Text("Formulir", color = Color.Black) }
                            }

                        }
                    }
    ){ isiRuang ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Jadwal Saya",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                ))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {


                itemsIndexed(allBiodata) { _, data ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.LightGray)
                            .padding(20.dp)
                            .padding(bottom = 12.dp)
                    ) {
//                      baris bertama nya
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Mata Kuliah:",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = data.MataKuliah,
                                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                                )
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Angkatan :",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = data.Angkatan,
                                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                                )
                            }
                        }
//                        row baris kedua
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Kelas :",
                                    style = MaterialTheme.typography.labelMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = data.Kelas,
                                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
                                )
                            }

                        }

                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }

            }
        }

    }
}