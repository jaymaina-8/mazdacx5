package com.example.mazdacx5.Navigations


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mazdacx5.ui.theme.Screen.home.Home_Screen
import com.example.mazdacx5.ui.theme.Screen.login.Login_Screen
import com.example.mazdacx5.ui.theme.Screen.register.Register_Screen
import com.example.mazdacx5.ui.theme.products.AddProductsScreen
import com.example.mazdacx5.ui.theme.products.UpdateProductsScreen
import com.example.mazdacx5.ui.theme.products.ViewProductsScreen
import com.example.mazdacx5.ui.theme.products.ViewUploadsScreen


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
        composable(ROUTE_HOME) {
            Home_Screen(navController)
        }
        composable(ROUTE_LOGIN) {
            Login_Screen(navController)
        }
        composable(ROUTE_REGISTER) {
            Register_Screen(navController)
        }

    composable(ROUTE_ADD_PRODUCT) {
        AddProductsScreen(navController)
    }
    composable(ROUTE_VIEW_PRODUCT){
        ViewProductsScreen(navController)
    }
    composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
        UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
    }
    composable(ROUTE_VIEW_UPLOAD){
        ViewUploadsScreen(navController)
    }
    }
}