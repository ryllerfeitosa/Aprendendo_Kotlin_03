package com.example.componentesestado

import android.R.attr.contentDescription
import android.R.attr.text
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentesestado.ui.theme.ComponentesEstadoTheme
import com.example.componentesestado.ui.theme.Righteus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    basicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun basicComponentsScreen(modifier: Modifier = Modifier) {
    var textFieldValue by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var kotlin by remember {
        mutableStateOf(false)
    }
    var jetPackCompose by remember {
        mutableStateOf(false)
    }
    var android by remember {
        mutableStateOf(false)
    }
    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }
    var corFundo by remember {
        mutableStateOf(Color(239,247,207))
    }
    val quantidade = remember {
        mutableStateOf("")
    }
    Column(
        modifier   //Permite editar e mudar os padroes da coluna
            .fillMaxSize()
            .background(corFundo)
    ) {
            Text(
                text = "Aulas android",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = Color(0xFF3DDC84),
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                letterSpacing = 4.sp
            )
            Text(
                text = "com Jetpack Compose",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(66,134,244),
                fontFamily = Righteus,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            TextField(
                value = textFieldValue,
                onValueChange = { novoValor ->
                    textFieldValue = novoValor
                },
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                label = {
                    Text(text = "Nome e sobrenome")
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66,133,244)
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66,133,244)
                    )
                },
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    bottomEnd = 32.dp
                ),
                modifier = Modifier.fillMaxWidth()
            )
        Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = quantidade.value,
                onValueChange = { novoValor ->
                    Log.i("teste", novoValor)
                    quantidade.value = novoValor
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                placeholder = {
                    Text(text = "Insira a quantidade")
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Red,
                    unfocusedPlaceholderColor = Color.Magenta
                ),
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    bottomEnd = 32.dp
                ),
                modifier = Modifier.fillMaxWidth()
            )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Digite o seu email")
            },
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Red
            )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = {kotlin = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetPackCompose,
                onCheckedChange = {jetPackCompose = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Jetpack compose")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = {android = it},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                )
            )
            Text("Android")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = {sistemaSelecionado = 0}
            )
            Text(text = "MacOs")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = {sistemaSelecionado = 1}
            )
            Text(text = "Windows")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = {sistemaSelecionado = 2}
            )
            Text(text = "Linux")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    corFundo = Color.Green
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Green
                ),
                border = BorderStroke(4.dp, Color.Red),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(   imageVector = Icons.Default.Star,
                            contentDescription = "Estrela")
                    Text(text = "Clique aqui!")
                }
            }
            OutlinedButton(
                onClick = {corFundo = Color.Yellow}
            ) {Text(text = "Outro botao") }
        }
    }
}

@Composable
fun AndroidEnemy(
    color: Color,
    modifier: Modifier = Modifier
){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color),
        contentDescription = "Android Enemy"
    )
}
