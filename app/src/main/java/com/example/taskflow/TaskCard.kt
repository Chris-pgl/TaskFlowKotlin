package com.example.taskflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard(
    /**La task che deve mostrare*/
    task: Task,
    /**onCardClick è un evento cliccable*/
    onCardClick: () -> Unit,
    /**onToggleDone anche questo è un veneto cliccable*/
    onToggleDone: () -> Unit
) {
    Card(
        onClick = { onCardClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        //TODO sistemare il padding
        Row(
            modifier = Modifier.padding(16.dp)
        ) { }
    }
}