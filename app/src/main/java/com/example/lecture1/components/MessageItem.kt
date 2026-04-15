package com.example.lecture1.components

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.integerArrayResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture1.R
import com.example.lecture1.model.Message
import com.example.lecture1.model.MessageType

import com.example.lecture1.ui.theme.Lecture1Theme
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Composable
fun MessageItem(
    message: Message,
    onClick: (Message) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(message)
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.picture),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = message.name,
                fontWeight = FontWeight(700),
                color = Color.White,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "4:20 PM",
                fontWeight = FontWeight(400),
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(4.dp))

            if (message.messageType == MessageType.Unread) {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFF4CC38A), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "3",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            if (message.messageType == MessageType.Typing) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(2) {
                        Box(
                            modifier = Modifier
                                .size(4.dp)
                                .background(Color(0xFF4CC38A), CircleShape)
                        )
                    }
                }
            }
        }
    }
}