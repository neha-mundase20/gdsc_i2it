package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeappTheme
import java.time.temporal.TemporalQueries.offset




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeappTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    roadmap()
                }
            }
        }
    }
}

@Composable
fun dataCard(d:appData,modifier: Modifier=Modifier){
//    var value by rememberSaveable{
//        mutableStateOf(1)
//    }
//    val uriHandler = LocalUriHandler.current
//    when(value){
//        1->uriHandler.openUri(R.string.link_1.toString())
//        2->uriHandler.openUri(R.string.link_2.toString())
//        3->uriHandler.openUri(R.string.link_3.toString())
//        else->uriHandler.openUri(R.string.link_4.toString())
//    }
    //val uriHandler = LocalUriHandler.current
    Card(modifier = Modifier.padding(8.dp), elevation = 6.dp,shape= RoundedCornerShape(17.dp)) {
        Column() {
            Image(painter = painterResource(id = d.imageId), contentDescription ="subscreens"
                ,modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp),
                contentScale = ContentScale.Crop)}
            TextButton(onClick = { /*uriHandler.openUri(d.linkId.toString())*/}, modifier = Modifier.padding(top =180.dp)) {
                Text(text = stringResource(id = d.stringResourceId)
                    ,modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.h6)
            }
            }
        }

@Composable
fun dataList(loadData:List<appData>,modifier: Modifier) {
    Column() {
        Text(text = stringResource(id = R.string.screen_title),modifier = Modifier.padding(57.dp),
            style = MaterialTheme.typography.h4
            ,textAlign = TextAlign.Center,fontWeight = FontWeight.Bold,fontStyle = FontStyle.Italic)
        LazyColumn {
            items(loadData) { appData ->
                dataCard(appData)
            }
        }
    }
}

@Composable
fun roadmap(){
    dataList(loadData = dataSource().loadData(), modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeappTheme {
        roadmap()
    }
}