package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(android.graphics.Color.parseColor("#D2E8D4"))
                ) {
                    BirthdayCard()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCard() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProfileSection()
        ContactInfo()
    }
}

@Composable
fun TextWithIcon(text : String, icon : ImageVector) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically

            ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(android.graphics.Color.parseColor("#137546"))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text=text
        )
    }
}

@Composable
fun ProfileSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier =  Modifier
                .size(120.dp)
                .background(Color(android.graphics.Color.parseColor("#073042")))
        )


        Text(
            text = "Joshua Olaoye",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top=4.dp, bottom = 4.dp)
        )

        Text(
            text = "Native Android Developer",
            color = Color(android.graphics.Color.parseColor("#137546"))
        )
    }
}

@Composable
fun ContactInfo() {
    Column {
        TextWithIcon(
            text="+1 (469) 988-9925",
            icon=Icons.Default.Phone
        )

        TextWithIcon(
            text="@joolaoye",
            icon=Icons.Default.Share
        )

        TextWithIcon(
            text="joshuaolaoye46@gmail.com",
            icon=Icons.Default.Email
        )
    }
}