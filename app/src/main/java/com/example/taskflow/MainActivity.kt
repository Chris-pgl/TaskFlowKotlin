package com.example.taskflow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    /**
     * Il .systemBarPadding() mi crea un bordo pre impostato che si modifica in base alla nav bar
     * */
    //Questa variabile sarà lo stato del button Portfolio
    val buttonClickedState = remember { mutableStateOf(false) }
    Surface( modifier = Modifier.fillMaxWidth().fillMaxHeight().systemBarsPadding(), /*color = Color.Cyan*/) {
        Card(modifier = Modifier.width(200.dp).padding(8.dp)
            .height(390.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            /**
             * elevation è un drop shadow della Card
             * */
            elevation = CardDefaults.cardElevation(4.dp),
            /**
             * colors è il background della Card
             * */
            colors = CardDefaults.cardColors(containerColor = Color.White)){

            Column(modifier = Modifier
                .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile(modifier = Modifier.size(135.dp))
                Divider(thickness = 3.dp, color = Color.LightGray  )
                //Create info ha una Card in cui abbiamo inserito i text per provare
                //si piò anche eliminare la Card e mantenere i text
                CreateInfo()
                BtnPortfolio()







            }




        }
    }
}

/**
 * Preview della della Home Activity
 * */
@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    CreateBizzCard()
}


/**
 * Miniature for profile picture
 */
@Composable
fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image2),
            contentDescription = "profile image",
            modifier = Modifier.clip(CircleShape)
                .border(2.dp,
                    Color.LightGray, //Prova black per vedere meglio il risultato
                    CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}


/**
 * Text for info under profiler picture
 * */
@Composable
fun CreateInfo(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Chris P.",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Blue
        )
        Text(
            text = "Android Compose Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "@Chris-pgl",
            style = MaterialTheme.typography.bodyMedium
        )
    }


}


/**
 * Bottone Portfolio
 * */
@Composable
fun BtnPortfolio(modifier: Modifier = Modifier) {
    var buttonClickedState = remember { mutableStateOf(false) }
    Button(onClick = {
        //!true fa in modo che quando il button viene cliccato, attiva e disattiva
        buttonClickedState.value = !buttonClickedState.value

        Log.d("Button", "ButtonPortedfolio: Clicked")
    }){
        Text(text = "Portfolio", style = MaterialTheme.typography.bodyMedium)
    }
    if(buttonClickedState.value){
        ShowContent()
    }else{
        Box(){
        }
    }
}

@Preview
@Composable
fun ShowContent(){
    Box(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
            shadowElevation = 4.dp,
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(2.dp, Color.LightGray)) {
            Portfolio(data = listOf(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5",
                "Project 6",
                "Project 7"))
        }
    }
}

/**
 * Questa gestisce la lista di progetti che miostra cliccando il btn Portfolio
 * */
@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier
        .height(300.dp)
        .padding(8.dp)){
        items(data){
                item ->
            Card(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp)) {
                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.surface).fillMaxWidth()
                    .padding(1.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "My personal projects on GitHub", style = MaterialTheme.typography.bodySmall)
                        Text(text = "@Chris-pgl", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)

                    }
                }
            }
        }
    }
}
