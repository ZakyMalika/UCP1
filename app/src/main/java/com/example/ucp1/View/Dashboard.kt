package com.example.ucp1.View

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(onBeranda: () -> Unit,
              onForm: () -> Unit,
              modifier: Modifier = Modifier){
    var checked by remember { mutableStateOf(false) }



    Scaffold (
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Edit Profil",
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_200))
            )
        }
                ,
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
                                onClick = onBeranda,
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                                    border = BorderStroke(1.dp, Color.LightGray)
                                ) { Text("Login", color = Color.Black) }
                            }

                        }
                    }
    ){ isiRuang ->

        Column(modifier = Modifier
            .padding( top = 150.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {

            val gambar1 = painterResource(id = R.drawable.logo)
            Image(
                painter = gambar1,
                contentDescription = null,
                modifier = Modifier
                    .size(size = 150.dp)
                    .padding(all = 1.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Muhammad Zaky Malika")
            Text(text = "20230140017")


            Spacer(modifier = Modifier.height(30.dp))

            Text(text = "JADWAL SAYA")
            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.fillMaxWidth()) {

                Column(modifier = Modifier
                    .padding(1.dp),
                    verticalArrangement = Arrangement.Center)
                    {

                        Row() {
                            Text(text = "Mata Kuliah:")
                            Spacer(modifier = Modifier.width(30.dp))

                            Text(text = "Pengembangan Aplikasi Mobile")

                        }
                        Row {
                            Text(text = "Angkatan:")
                            Spacer(modifier = Modifier.width(30.dp))

                            Text(text = "2023")
                        }
                        Row {
                            Text(text = "Kelas:")
                            Spacer(modifier = Modifier.width(30.dp))

                            Text(text = "A")
                        }
                        Button(
//                            onClick = {},
//                            enabled = checked,
                onClick = onForm,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                            border = BorderStroke(1.dp, Color.LightGray)
                        )
                        { Text("Formulir", color = Color.Black) }
                    }

            }





        }
    }
}