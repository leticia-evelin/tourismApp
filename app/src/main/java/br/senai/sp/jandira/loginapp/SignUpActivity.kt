package br.senai.sp.jandira.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.ui.theme.LOGINAppTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LOGINAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {

    //inicio column principal
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {

        // inicio row
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End){

            Card(modifier = Modifier
                .width(120.dp)
                .height(40.dp),
                shape = RoundedCornerShape(bottomStart = 16.dp),
                backgroundColor = Color(207, 6, 240)
                ) {
            }

        } // final row

        // Inicio da Column login
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.title_sign),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(206, 1, 240)
            )

            Text(text = stringResource(id = R.string.description_new_account),
            fontSize = 14.sp,
            color = Color(160, 156, 156)
            )
        } // Fim da column login


    } //final column principal
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LOGINAppTheme {
       SignUpActivity()
    }
}