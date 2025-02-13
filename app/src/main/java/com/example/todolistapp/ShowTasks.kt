package com.example.todolistapp

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ShowTasks(navController: NavHostController, taskText: String) {
    // Split the taskText into a list of tasks
    val task = taskText.split("|")

    // this is type int coz it will only store the index of the task
    val selectedTasks = remember { mutableStateListOf<Int>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        // Top Bar: "Today's Tasks"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Today's Tasks",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
    }





        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                
        ) {
            //  itemsIndexed is used to get both the index and the task
            itemsIndexed(task) { index, task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable {
                            if (selectedTasks.contains(index)) {
                                selectedTasks.remove(index)
                            } else {
                                selectedTasks.add(index)
                            }
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = if (selectedTasks.contains(index)) Color(0xFFDFFFD6) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width=2.dp, color = Color.Black)
                        .clickable {
                            // when the task is clicked its index is either added to or removed from the selectedtasks list
                            if (selectedTasks.contains(index)) {
                                selectedTasks.remove(index)
                            } else {
                                selectedTasks.add(index)
                            }
                        }
                        .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${index + 1}. $task", // Display the task with its index
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.weight(1f) // Take up remaining space
                    )

                    // lastly if task's index is in selected tasks, it will show the green tick
                    if (selectedTasks.contains(index)) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = Color.Green,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }

}}}