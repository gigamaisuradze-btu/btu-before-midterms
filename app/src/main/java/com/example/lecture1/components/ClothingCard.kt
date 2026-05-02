package com.example.lecture1.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lecture1.model.ClothingItem

@Composable
fun ClothingCard(
    clothingItem: ClothingItem?,
    onFavoriteClick: () -> Unit,
    onItemClick: (ClothingItem) -> Unit,
    isLoading: Boolean = false
) {
    val shimmerColors = listOf(
        Color(0xFF30444E).copy(alpha = 0.6f),
        Color(0xFF3D5A67).copy(alpha = 0.9f),
        Color(0xFF30444E).copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition(label = "shimmer")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmer_translate"
    )

    val shimmerBrush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnim - 300f, 0f),
        end = Offset(translateAnim, 0f)
    )

    Column(
        modifier = Modifier.then(
            if (!isLoading) Modifier.clickable {
                if (clothingItem != null) {
                    onItemClick.invoke(clothingItem)
                }
            } else Modifier
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(150F / 210F)
                .clip(RoundedCornerShape(32.dp))
                .then(
                    if (isLoading) Modifier.background(shimmerBrush) else Modifier
                )
        ) {
            if (!isLoading) {
                Image(
                    painter = painterResource(clothingItem?.image ?: 0),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                ) {
                    IconButton(onClick = { onFavoriteClick.invoke() }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            tint = if (clothingItem?.isFavorite == true) Color.Red else Color.LightGray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (isLoading) {
            // Title placeholder
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .fillMaxWidth(0.6f)
                    .clip(RoundedCornerShape(4.dp))
                    .background(shimmerBrush)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Price placeholder
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .fillMaxWidth(0.35f)
                    .clip(RoundedCornerShape(4.dp))
                    .background(shimmerBrush)
            )
        } else {
            Text(
                text = clothingItem?.title ?: "",
                color = Color(0xFF96A7AF),
                fontSize = 14.sp,
                fontWeight = FontWeight(400)
            )

            Text(
                text = "$${clothingItem?.price}",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight(700)
            )
        }
    }
}