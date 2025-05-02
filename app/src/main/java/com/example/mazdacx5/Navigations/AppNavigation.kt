package com.example.mazdacx5.Navigations


import ViewStudents
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mazdacx5.ui.theme.Screen.home.HomeScreen
import com.example.mazdacx5.ui.theme.Screen.login.Login_Screen
import com.example.mazdacx5.ui.theme.Screen.register.Register_Screen

import com.example.mazdacx5.ui.theme.products.AddstudentScreen
import com.example.mazdacx5.ui.theme.products.UpdatestudentScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_LOGIN
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination,
    ) {

        composable(ROUTE_ADD_STUDENT) { AddstudentScreen(navController) }
        composable(ROUTE_VIEW_STUDENTS) { ViewStudents(navController) }
        composable("$ROUTE_UPDATE_STUDENT/{studentId}") { passedData ->
            UpdatestudentScreen(
                navController, passedData.arguments?.getString("studentId")!!
            )
        }
            composable(ROUTE_HOME) {
                HomeScreen(navController)
            }
            composable(ROUTE_LOGIN) {
                Login_Screen(navController)
            }
            composable(ROUTE_REGISTER) {
                Register_Screen(navController)
            }


        }
    }
