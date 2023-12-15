package com.example.movieapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.moobeez.R


@Composable
fun ButtonFinish(currentPage : Int) {

    Row(
        modifier = Modifier
            .padding(bottom = 36.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPage == 3) Arrangement.Center else
            Arrangement.SpaceBetween,
    ) {
        if (currentPage == 3){
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Comencemos", modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 40.dp),
                    color = colorResource(id = R.color.Primario))
            }
        }
    }
}