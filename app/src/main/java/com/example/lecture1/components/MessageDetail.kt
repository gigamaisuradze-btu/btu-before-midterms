package com.example.lecture1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture1.R
import com.example.lecture1.model.Message

@Composable
fun MessageDetail(
    name: String
) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.picture),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(1F)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight(700),
                    color = Color.White,
                    fontSize = 16.sp
                )
//
//                Text(
//                    text = message.phoneNumber,
//                    fontWeight = FontWeight(400),
//                    color = Color.White,
//                    fontSize = 14.sp
//                )
//
//                Text(
//                    text = message.email,
//                    fontWeight = FontWeight(400),
//                    color = Color.White,
//                    fontSize = 14.sp
//                )
            }

            Icon(
                painter = painterResource(R.drawable.ic_arrow),
                contentDescription = null
            )
        }
}