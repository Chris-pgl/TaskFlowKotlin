package com.example.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    Surface( modifier = Modifier.fillMaxWidth().fillMaxHeight().systemBarsPadding(), /*color = Color.Cyan*/) {
        Card(modifier = Modifier.width(200.dp).padding(8.dp)
            .height(390.dp),
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            /**
             * elevation è come un drop shadow della Card
             * */
            elevation = CardDefaults.cardElevation(4.dp),
            /**
             * colors è il background della Card
             * */
           colors = CardDefaults.cardColors(containerColor = Color.White)){

            Column(modifier = Modifier
                .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                CreateImageProfile()
                Divider(thickness = 3.dp, color = Color.LightGray  )
                CreateInfo()
                Divider(thickness = 3.dp, color = Color.LightGray  )
                Column(modifier = Modifier.padding(5.dp)) {

                }


            }




        }
    }
}

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
        modifier = Modifier//.size(150.dp)
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

@Composable
fun CreateInfo(modifier: Modifier = Modifier){
    Text(
        text = "Chris P.",
        style = MaterialTheme.typography.headlineMedium,
        color = Color.Blue)
    Text(
        text = "Android Compose Programmer",
        modifier = Modifier.padding(3.dp)
    )
}