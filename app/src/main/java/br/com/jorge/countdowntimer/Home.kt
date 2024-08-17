package br.com.jorge.countdowntimer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            Modifier
                .padding(start = 40.dp, end = 40.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            LazyColumnSection(start = 0, limit = 5, actual = 0, label = "Hours")
            Text(
                fontSize = 30.sp,
                text = ":")
            LazyColumnSection(start = 0, limit = 5, actual = 0, label = "Minutes")
            Text(
                fontSize = 30.sp,
                text = ":")
            LazyColumnSection(start = 0, limit = 5, actual = 0, label = "Seconds")
        }

        Row(
            Modifier
                .padding(top = 70.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier
                    .padding(end = 30.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.padding(end = 8.dp),
                    imageVector = Icons.Filled.Check, contentDescription = null)
                Text(text = "Start")
            }
            Button(
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.padding(end = 8.dp),
                    imageVector = Icons.Filled.Clear, contentDescription = null)
                Text(text = "Reset")
            }
        }
    }
}

@Composable
fun LazyColumnSection(start: Int,
                      limit: Int,
                      actual: Int,
                      label: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label)
        LazyColumn(
            Modifier.height(145.dp)
        ) {
            items(limit){ index ->
                Text(
                    fontSize = 40.sp,
                    text = "$index")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    Home()
}