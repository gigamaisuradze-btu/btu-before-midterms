package com.example.lecture1.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture1.model.Filter

@Composable
fun FilterCard(
    filterItem: Filter,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (filterItem.isSelected) Color(0xFF3ED598)
                else Color(0xFF30444E)
            )
            .padding(all = 12.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Text(
            text = filterItem.title,
            color = if (filterItem.isSelected) Color.White else Color(0xFF96A7AF),
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        )
    }
}