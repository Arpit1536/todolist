package com.example.todolistapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import com.example.todolistapp.R

@Composable
fun HomeScreen(navController: NavHostController) {
    var textFieldState by remember { mutableStateOf("") } // State for the TextField
    val tasks = remember { mutableStateListOf<String>() } // List to store tasks
    Box(modifier = Modifier.fillMaxSize())
    {
        Image(
            painter = painterResource(id=R.drawable.bgimage),
            contentDescription = "background image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // TextField for entering a task
            TextField(
                value = textFieldState,
                label = { Text("New task") },
                onValueChange = { textFieldState = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(2.dp, Color.Black)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Button to add a task
            Button(
                onClick = {
                    if (textFieldState.isNotEmpty()) {
                        tasks.add(textFieldState) // Add the task to the list
                        textFieldState = "" // Clear the TextField
                    }
                }
            ) {
                Text("Add Task")
                Icon(
                    painter = painterResource(id = R.drawable.plus2),
                    contentDescription = "plus",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button to navigate to the ShowTasks screen
            Button(
                onClick = {
                    navController.navigate("screen1/${tasks.joinToString("|")}") // Pass the list as a string
                }
            ) {
                Text("Show Tasks")
            }
        }
    }
}