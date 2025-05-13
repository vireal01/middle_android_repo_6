package ru.yandexpraktikum.notekeeper.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.yandexpraktikum.add_note.presentation.AddNoteScreen
import ru.yandexpraktikum.all_notes.presentation.AllNotesScreen

@Composable
fun NoteKeeperNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AllNotes.route
    ) {
        composable(route = Screen.AllNotes.route) {
            var allNotesComponent by remember { mutableStateOf<Any?>(null) }
            DisposableEffect(Unit) {
                onDispose {
                    allNotesComponent = null
                }
            }
            AllNotesScreen(
                onAddNoteClick = {
                    navController.navigate(Screen.AddNote.route)
                }
            )
        }
        composable(route = Screen.AddNote.route) {
            var addNoteComponent by remember { mutableStateOf<Any?>(null) }
            DisposableEffect(Unit) {
                onDispose {
                    addNoteComponent = null
                }
            }
            AddNoteScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}