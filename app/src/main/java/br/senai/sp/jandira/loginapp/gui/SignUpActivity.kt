package br.senai.sp.jandira.loginapp.gui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.loginapp.R
import br.senai.sp.jandira.loginapp.components.BottomShape
import br.senai.sp.jandira.loginapp.components.TopShape
import br.senai.sp.jandira.loginapp.model.User
import br.senai.sp.jandira.loginapp.repository.UserRepository
import br.senai.sp.jandira.loginapp.ui.theme.LOGINAppTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

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

    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }
    //abrir galeria de imagens e permitir selecionar a URI da foto
    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        photoUri = it
    }

    //variavel que vai guardar a imagem imagem mesmo - utilizando coil biblioteca
    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUri)
            .build()
    )

    var scrollState = rememberScrollState()

    var userNameState by remember {
        mutableStateOf("")
    }
    var phoneState by remember {
        mutableStateOf("")
    }
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    var over18State by remember {
        mutableStateOf(false)
    }

    //variavel que recebe o contexto
    val context = LocalContext.current


    //inicio column principal
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // inicio row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            TopShape()

        } // final row

        // Inicio da Column login
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.title_sign),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(206, 1, 240)
            )

            Text(
                text = stringResource(id = R.string.description_new_account),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )

            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.size(100.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.BottomEnd)
                        .offset(x = (0).dp, y = 0.dp),
                    shape = CircleShape,
                    backgroundColor = Color(232, 232, 232, 255)
                ) {
                    Image(
                        painter = if (photoUri == null) painterResource(id = R.drawable.user) else painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
                Image(
                    painter = painterResource(
                        id = R.drawable.baseline_add_a_photo_24
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .clickable { //tornando clicavel
                            launcher.launch("image/*") //* qualquer tipo de imagem, arquivo
                            var message = "nada"
                            Log.i(
                                "ds2m",
                                "${photoUri?.path ?: message}"
                            )
                        }
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
                modifier = Modifier
                    .height(300.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                //------------------
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = userNameState,
                    onValueChange = { userNameState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label =
                    {
                        Text(text = stringResource(id = R.string.username_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.person_24
                            ),
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
                    value = phoneState,
                    onValueChange = { phoneState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    label = {
                        Text(text = stringResource(id = R.string.phone_label))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.phone_android_24
                            ),
                            contentDescription = stringResource(
                                id = R.string.email_description

                            ),
                            tint = Color(207, 1, 240)
                        )
                    }
                )
                OutlinedTextField(
                    value = emailState,
                    onValueChange = { emailState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.email_24
                            ),
                            contentDescription = stringResource(
                                id = R.string.email_description

                            ),
                            tint = Color(207, 1, 240)
                        )
                    }
                )
                OutlinedTextField(
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(
                                id = R.drawable.lock_24
                            ),
                            contentDescription = stringResource(
                                id = R.string.email_description

                            ),
                            tint = Color(207, 1, 240)
                        )
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = over18State,
                        onCheckedChange = { over18State = it }
                    )
                    Text(text = stringResource(id = R.string.checkbox))
                }


                Spacer(modifier = Modifier.height(16.dp))

                //-----------
                Button(
                    onClick = {
                        saveUser(
                            userNameState,
                            phoneState,
                            emailState,
                            passwordState,
                            over18State,
                            photoUri?.path ?: " ", // manda path da foto se nao estiver nulo, ao contrario retorna vazio
                            context
                            )
                    },
                    colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row {

                        Text(
                            text = stringResource(id = R.string.button_create).uppercase(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.ExtraBold,
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = stringResource(id = R.string.question_sign_in),
                fontSize = 14.sp,
                color = Color(160, 156, 156)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(id = R.string.signin),
                modifier = Modifier.clickable {
                    // val intent = Intent(context, SignUpActivity::class.java)
                    // context.startActivity(intent)
                },
                fontSize = 14.sp,
                color = Color(247, 6, 246)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            BottomShape()
        }
    } //final column principal


}

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    profilePhotoUri: String,
    context: Context
) {
    //criando o objeto user
    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        isOver18 = isOver18,
        profilePhoto = profilePhotoUri

    )
    //criando uma instancia do repositorio
    val userRepository = UserRepository(context)

    //verificar se o usuario ja existe
    val user = userRepository.finUserByEmail(email)
    Log.i(
        "ds2m",
        "${user.toString()}"
    )
    
    //salvar usuario
    // se o user for nulo -> criar user
    if(user == null){
        val id = userRepository.save(newUser)
        Toast.makeText(
            context, "Created User #$id", //concatenacao com o id do user
            Toast.LENGTH_LONG // mensagem ficar por mais tempo
        ).show()
    } else {
        Toast.makeText(
            context, "User already exists!",
            Toast.LENGTH_LONG // mensagem ficar por mais tempo
        ).show()
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LOGINAppTheme {
        SignUpScreen()
    }
}