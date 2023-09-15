package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.ui.theme.poppins

@Composable
fun TitleListHome(title: String) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Text(
            text = title ,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left
            )
        )
        Text(
            text = " .",
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                letterSpacing = 0.5.sp,
                textAlign = TextAlign.Left,
                color = Color.Magenta,
            )
        )
    }
}