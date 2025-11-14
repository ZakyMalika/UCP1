package com.example.ucp1

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.View.Dashboard
import com.example.ucp1.View.Login
import com.example.ucp1.View.Formulir

enum class Navigasi {
    Dashboard,
    Daftar,
    Formulirs
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Navigasi.Dashboard.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Navigasi.Dashboard.name) {
            Login(
                // tombol di Dashboard bisa langsung navigasi ke daftar
                onNavigate = {
                    navController.navigate(Navigasi.Daftar.name)
                }
            )
        }

        composable(route = Navigasi.Daftar.name) {
            Dashboard(
                onBeranda = {
                    navController.popBackStack(Navigasi.Dashboard.name, inclusive = false)
                },
                onForm = {
                    navController.navigate(Navigasi.Formulirs.name)
                }
            )
        }

        composable(route = Navigasi.Formulirs.name) {
            Formulir(
                onBeranda = {
                    cancelAndBackToDaftar(navController)
                }
            )
        }
    }
}


private fun cancelAndBackToDaftar(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Daftar.name, inclusive = false)
}
