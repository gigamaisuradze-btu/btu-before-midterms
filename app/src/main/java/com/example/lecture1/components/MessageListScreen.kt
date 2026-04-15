package com.example.lecture1.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.lecture1.DataFactory
import com.example.lecture1.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MessageListScreen(
   onClick: (String) -> Unit
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            stickyHeader {
                Text(
                    text = "Your chats are here:",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = colorResource(R.color.background))
                        .padding(12.dp)
                )
            }

            items(DataFactory.messages) { message ->
                MessageItem(
                    message = message,
                    onClick = { clickedMessage ->
                        onClick.invoke(clickedMessage.name)
                    }
                )
            }
        }
    }
}