package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                ArtApp()
            }
        }
    }
}
@Composable
fun ArtApp() {
    var currentStep by remember { mutableStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        when (currentStep) {
            1 -> {
                ArtPiece(
                    title = stringResource(R.string.tituloObra1),
                    imageResId = R.drawable.obra1,
                    description = stringResource(R.string.DescripObra1),
                    onBeforeClick = { currentStep = 4 },
                    onNextClick = { currentStep = 2 }
                )
            }
            2 -> {
                ArtPiece(
                    title = stringResource(R.string.tituloObra2),
                    imageResId = R.drawable.obra2,
                    description = stringResource(R.string.DescripObra2),
                    onBeforeClick = { currentStep = 1 },
                    onNextClick = { currentStep = 3 }
                )
            }
            3 -> {
                ArtPiece(
                    title = stringResource(R.string.tituloObra3),
                    imageResId = R.drawable.obra3,
                    description = stringResource(R.string.DescripObra3),
                    onBeforeClick = { currentStep = 2 },
                    onNextClick = { currentStep = 4 }
                )
            }
            4 -> {
                ArtPiece(
                    title = stringResource(R.string.tituloObra4),
                    imageResId = R.drawable.obra4,
                    description = stringResource(R.string.DescripObra4),
                    onBeforeClick = { currentStep = 3 },
                    onNextClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun ArtPiece(
    title: String,
    imageResId: Int,
    description: String,
    onBeforeClick: () -> Unit,
    onNextClick: () -> Unit

) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Surface(
            modifier = Modifier
                .padding(45.dp)
                .fillMaxWidth(),
            color = Color.LightGray
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onBeforeClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Anterior",
                    fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = onNextClick,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Siguiente",
                    fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtApp()
    }
}