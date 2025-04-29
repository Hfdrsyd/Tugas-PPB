package com.example.mygallery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mygallery.ui.screens.GalleryScreen
import com.example.mygallery.ui.screens.PhotoDetailScreen
import com.example.mygallery.ui.screens.UploadScreen
import com.example.mygallery.viewmodel.PhotoViewModel
import com.example.mygallery.viewmodel.ThemeViewModel

sealed class Screen(val route: String) {
    object Gallery : Screen("gallery")
    object PhotoDetail : Screen("photo/{photoId}") {
        fun createRoute(photoId: String) = "photo/$photoId"
    }
    object Upload : Screen("upload")
}

@Composable
fun MyGalleryNavHost(
    navController: NavHostController = rememberNavController(),
    photoViewModel: PhotoViewModel = viewModel(),
    themeViewModel: ThemeViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Gallery.route
    ) {
        composable(Screen.Gallery.route) {
            GalleryScreen(
                photos = photoViewModel.photos,
                onPhotoClick = { photo ->
                    navController.navigate(Screen.PhotoDetail.createRoute(photo.id))
                },
                onAddClick = {
                    navController.navigate(Screen.Upload.route)
                },
                isDarkMode = themeViewModel.isDarkMode,
                onToggleTheme = {
                    themeViewModel.toggleTheme()
                }
            )
        }

        composable(
            route = Screen.PhotoDetail.route,
            arguments = listOf(
                navArgument("photoId") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val photoId = backStackEntry.arguments?.getString("photoId") ?: ""
            val photo = remember(photoId) { photoViewModel.getPhotoById(photoId) }

            photo?.let {
                PhotoDetailScreen(
                    photo = it,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Screen.Upload.route) {
            UploadScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onUploadClick = { imageUrl, title, description ->
                    photoViewModel.uploadPhoto(imageUrl, title, description)
                    navController.popBackStack()
                }
            )
        }
    }
}