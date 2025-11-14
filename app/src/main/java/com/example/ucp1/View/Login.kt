package com.example.ucp1.View

import android.R.attr.checked
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Login(onNavigate: () -> Unit,
          modifier: Modifier = Modifier){

    var textUsername by remember { mutableStateOf("") }
    var textPass by remember { mutableStateOf("") }

    var Username by remember { mutableStateOf("") }
    var Pass by remember { mutableStateOf("") }

//    check
    var checked by remember { mutableStateOf(false) }
//    dialog
    var showDialog by remember { mutableStateOf(false) }






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
                            text = stringResource(id = R.string.tampil),
                            color = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_200))
            )}
//        },
//        bottomBar = {
//            BottomAppBar(
//                containerColor = colorResource(id = R.color.purple_200),
//            ) {
//                Text(
//                    modifier = Modifier.fillMaxWidth(),
//                    textAlign = TextAlign.Center,
//                    text = "Bottom App Bar",
//                    color = Color.White
//                )
//            }
//        }
    ) { isiRuang ->

        Column(
            modifier = Modifier
                .padding(isiRuang)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.username),
                fontSize = 15.sp,
                color = Color.Black
            )
            OutlinedTextField(
                value = textUsername,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(350.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { textUsername = it }
            )

            Text(
                text = stringResource(id = R.string.pass),
                fontSize = 15.sp,
                color = Color.Black
            )
            OutlinedTextField(
                value = textPass,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(350.dp),
                label = { Text(text = "Password") },
                onValueChange = { textPass = it }
            )

//            checkbox
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 30.dp, start = 30.dp)
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    modifier = Modifier.scale(1.3f),
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFF3F51B5),
                        uncheckedColor = Color.Gray
                    )
                )

                Text(text = "Setuju",
                    fontSize = 15.sp,
                    color = Color.Black)
            }

            Button(
//                onClick = {},
                enabled = checked,
                onClick = onNavigate,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color.LightGray)
            )
            { Text("Login", color = Color.Black) }


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
                           Text(text = "Saya setuju lanjut login")
                        }
                    },
                    confirmButton = {
                        Button(
//                            onClick = {true},
                            onClick = onNavigate,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Blue
                            )
                        ) {
                            Text("OK")
                        }
                    }

                )
            }



        }
    }
}