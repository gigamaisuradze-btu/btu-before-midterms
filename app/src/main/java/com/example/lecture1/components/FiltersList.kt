package com.example.lecture1.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lecture1.model.Filter

@Composable
fun FiltersList(
    filters: List<Filter>,
    onFilterClick: (Filter) -> Unit
) {
    LazyRow(
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(filters) { filter ->
            FilterCard(filterItem = filter, onClick = {onFilterClick.invoke(filter)})
        }
    }
}