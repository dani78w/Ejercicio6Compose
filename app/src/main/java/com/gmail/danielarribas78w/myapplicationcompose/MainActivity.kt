package com.gmail.danielarribas78w.myapplicationcompose

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.gmail.danielarribas78w.myapplicationcompose.ui.theme.MyApplicationComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var raza = mutableStateOf("")

        setContent {
            MyApplicationComposeTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row() {
                        Column() {
                            Row {
                                Text("RAZAS",  fontSize = 30.sp, modifier = Modifier.padding(10.dp))
                            }
                            Row {
                                grid1(raza)
                            }
                            Row() {
                                Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when" +
                                        " an unknown printer took a galley of type and scrambled it to make a type specimen " +
                                        "book. It has survived not only five centuries, but also the leap into electronic" +
                                        " typesetting, remaining essentially unchanged. It was popularised in the 1960s with" +
                                        " the release of Letraset sheets containing Lorem Ipsum passages, and more recently" +
                                        " with desktop publishing software like Aldus PageMaker including versions of Lorem " +
                                        "Ipsum",fontSize = 10.sp, modifier = Modifier.padding(10.dp))
                            }
                            Row {
                                imagenRaza(raza)
                            }
                        }
                    }
                }



            }
        }
    }
}

@Composable
fun greeting(name: String,raza: MutableState<String>) {
    Row(

        horizontalArrangement = Arrangement.Center,

        modifier = Modifier
            .height(140.dp)
            .wrapContentWidth()
            .padding(10.dp, 10.dp, 10.dp, 10.dp)
            .shadow(5.dp)


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .background(MaterialTheme.colors.primary)
                .padding(10.dp)
                .height(120.dp)
                .wrapContentWidth()





        ){
            Text(
                text = name,
                color = Color.White,
                fontSize= 30.sp,
                modifier = Modifier.padding(0.dp),
                textAlign = TextAlign.Center,

                )

            Text(
                text = "hola diablo!",
                fontSize= 10.sp,
                modifier = Modifier.padding(vertical = 3.dp),
                textAlign = TextAlign.Center,
                color = Color.White,


                )
            Button(
                onClick = {
                   raza.value= name
                },
                modifier = Modifier.shadow(5.dp, RoundedCornerShape(10.dp)),
                // Uses ButtonDefaults.ContentPadding by default
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp,
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like")
            }
        }

    }
    }
@Composable
fun grid1(raza: MutableState<String>){
    Row{

        Column() {

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .horizontalScroll(ScrollState(150), enabled = true)

            ) {
                val razas = listOf("HUMANO", "ELFO", "ENANO", "HALFLING", "MEDIANO", "DRACÓNICO", "GIGANTE", "GNOMO","ORCO", "TIEFLING")
                for (i in 0..9){

                    greeting(razas[i],raza)

                }
            }

            
        }
    }

}
@Composable
fun imagenRaza(raza: MutableState<String>){
    Row(
        horizontalArrangement = Arrangement.Center,

        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()


    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier

                //.background(Color(0xFFE6E6E6))
                .padding(10.dp)
                .fillMaxSize()


        ) {
            imageResourceDemo(raza.value)

            // Text(text = raza.value, fontSize = 30.sp, modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun imageResourceDemo(raza:String) {
    val context = LocalContext.current


    val imagenes: Map<String, Painter> = mapOf(
        Pair("HUMANO", painterResource(id = R.drawable.human)),
        Pair("ELFO", painterResource(id = R.drawable.elfo)),
        Pair("ENANO", painterResource(id = R.drawable.enano)),
        Pair("HALFLING", painterResource(id = R.drawable.halfling)),
        Pair("MEDIANO", painterResource(id = R.drawable.mediano)),
        Pair("DRACÓNICO", painterResource(id = R.drawable.dragon)),
        Pair("GIGANTE", painterResource(id = R.drawable.gigante)),
        Pair("GNOMO", painterResource(id = R.drawable.gnomo)),
        Pair("ORCO", painterResource(id = R.drawable.orco)),
        Pair("TIEFLING", painterResource(id = R.drawable.tiefling))
    )
    if(raza == ""){
        Text(text = "SELECCIONA UNA RAZA", fontSize = 30.sp, modifier = Modifier.padding(10.dp), textAlign = TextAlign.Center)
    }else {

        Image(painter = imagenes.getValue(raza), contentDescription = "", modifier = Modifier
            .height(400.dp)
            .width(400.dp)
        )
        val context = LocalContext.current
        Button(onClick = {
            val intent = Intent(context , MainActivity2::class.java).apply {
                putExtra(EXTRA_MESSAGE, raza)
            }
            context.startActivity(intent)

        }, modifier = Modifier.padding(10.dp)) {
            Text("Button")
        }


    }
}

@Composable
fun MainScreen2() {


    Button(onClick = {

    }) {
        Text(text = "Show List")
    }
}


