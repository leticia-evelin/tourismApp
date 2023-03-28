package br.senai.sp.jandira.loginapp.gui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.components.BottomShape
import br.senai.sp.jandira.loginapp.components.TopShape
import br.senai.sp.jandira.loginapp.components.TopShape
import br.senai.sp.jandira.loginapp.ui.theme.LOGINAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LOGINAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen()
                }

            }
        }
    }
}

@Composable
fun LoginScreen(){

    val context = LocalContext.current

    // Column principal
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {

        // Inicio da Row da forma
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End) {
            TopShape() // fun topform para forma no canto superior
        } //Fim da row da forma

        // Inicio da Column login
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.login),
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(206, 1, 240)
            )
            Text(text = stringResource(id = R.string.please),
            fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
        } // Fim da column login

       // Inicio da column formulario
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.email))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                        id = R.drawable.email_24),
                        contentDescription = stringResource(
                            id = R.string.email_description

                        ),
                        tint = Color(207, 1, 240)
                    )
                },
                colors = TextFieldDefaults
                    .outlinedTextFieldColors(
                        focusedBorderColor = Color(207, 1, 240),
                        unfocusedBorderColor = Color(207, 1, 240),
                    )
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(text = stringResource(id = R.string.password))
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(
                            id = R.drawable.lock_24),
                        contentDescription = stringResource(
                            id = R.string.email_description

                        ),
                        tint = Color(207, 1, 240)
                    )
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row() {

                    Text(text = stringResource(id = R.string.button_sign).uppercase(),
                        fontSize = 16.sp,
                        fontWeight =  FontWeight.ExtraBold,
                        color = Color.White
                    )
                    Icon(
                       painter = painterResource
                           (id = R.drawable.arrow_forward_24),
                       contentDescription = " ",
                       tint = Color.White
                   )
                }

            }

        } //Fim da column formulario

        //Inicio da row don't have an account
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.End) {

            Text(
                text = stringResource(id = R.string.question_account),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.signup),
                modifier = Modifier.clickable {
                  val intent = Intent(context, SignUpActivity::class.java)
                   context.startActivity(intent)
                },
                fontSize = 14.sp,
                color = Color(247, 6, 246)
            )
        } //Fim da row don't have an account

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
          BottomShape()
        }

    } // Fim da column principal
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
     LOGINAppTheme {
         LoginScreen()
     }
}




  