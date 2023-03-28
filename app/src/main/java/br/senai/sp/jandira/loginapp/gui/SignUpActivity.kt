package br.senai.sp.jandira.loginapp.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.components.BottomShape
import br.senai.sp.jandira.loginapp.components.TopShape
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

    var scrollState = rememberScrollState()


    //inicio column principal
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween) {

        // inicio row
        Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End){

           TopShape()

        } // final row

        // Inicio da Column login
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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

            Spacer(modifier = Modifier.height(32.dp))
            Box(modifier = Modifier.size(100.dp),
               contentAlignment = Alignment.BottomEnd
            ){
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (0).dp, y = 0.dp),
                shape = CircleShape,
                    backgroundColor = Color(232,232,232,255)
                ) {
                    Image(painter = painterResource(id = R.drawable.user),
                        contentDescription = null)
                }
                Image(
                    painter = painterResource(
                        id = R.drawable.baseline_add_a_photo_24
                    ),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.BottomEnd)
                    )

            }
        } // Fim da column login

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.End
        ) {

            Column(
                modifier = Modifier.height(300.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                //------------------
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = " " ,
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label =
                    {
                        Text(text = stringResource(id = R.string.username_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.person_24),
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
                        Text(text = stringResource(id = R.string.phone_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.phone_android_24),
                            contentDescription = stringResource(
                                id = R.string.email_description

                            ),
                            tint = Color(207, 1, 240)
                        )
                    }
                )
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
                    }
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {}
                    )
                    Text(text = stringResource(id = R.string.checkbox))
                }


                Spacer(modifier = Modifier.height(16.dp))

                //-----------
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row() {

                        Text(text = stringResource(id = R.string.button_create).uppercase(),
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
            }

        }

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
                   // val intent = Intent(context, SignUpActivity::class.java)
                   // context.startActivity(intent)
                },
                fontSize = 14.sp,
                color = Color(247, 6, 246)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {
            BottomShape()
        }
    } //final column principal


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LOGINAppTheme {
       SignUpScreen()
    }
}