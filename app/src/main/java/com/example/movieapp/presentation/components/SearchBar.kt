package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.Primario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Box(modifier = Modifier.padding(all = 10.dp)) {
        TextField(
            value = "",
            onValueChange = {  },
            label = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Primario,
                )
            },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}