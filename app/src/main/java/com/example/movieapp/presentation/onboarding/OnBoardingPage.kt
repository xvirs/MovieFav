package com.example.movieapp.presentation.onboarding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moobeez.R
import com.example.movieapp.presentation.Dimensions.MediumPadding1
import com.example.movieapp.presentation.Dimensions.MediumPadding2
import com.example.movieapp.presentation.Dimensions.MediumPadding3
import com.example.movieapp.presentation.components.ButtonFinish
import com.example.movieapp.presentation.components.PageIndicator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    item: List<Page>,
    pagerState: PagerState
) {
    Box (modifier = Modifier.background(Color.Black)) {
        Column (verticalArrangement = Arrangement.SpaceEvenly,  modifier = Modifier.fillMaxHeight()) {
            HorizontalPager(state = pagerState, count = item.size){page ->
                Column (modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center){
                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(horizontal = MediumPadding1, vertical = MediumPadding2).align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold, fontSize = 38.sp),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    LoaderData(modifier = Modifier
                        .size(300.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally), item[page].image)
                    Spacer(modifier = Modifier.height(MediumPadding3))
                    Text(
                        text = item[page].description,
                        modifier = Modifier.padding(horizontal = MediumPadding1, vertical = MediumPadding2).align(Alignment.CenterHorizontally),
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 17.sp),
                        color = colorResource(id = R.color.Grisesito),
                        textAlign = TextAlign.Center
                    )
                }
            }
            PageIndicator(item.size, pagerState.currentPage )
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)){
            ButtonFinish(pagerState.currentPage)
        }
    }
}
