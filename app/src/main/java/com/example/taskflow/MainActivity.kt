package com.example.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskflow.ui.theme.TaskFlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //Surface conteiner usa i background colori definiti in TaskFlowTheme
            TaskFlowTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CreateBizzCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizzCard(){ //Il Color in surface è solo per prova "sfondo della surface" con sopra Card
    Surface( modifier = Modifier.fillMaxWidth().fillMaxHeight(), color = Color.Blue) {
        Card(modifier = Modifier.width(200.dp)
            .height(390.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            /*colore della Card*/
           colors = CardDefaults.cardColors(containerColor = Color.LightGray)) { }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CreateBizzCard()
}