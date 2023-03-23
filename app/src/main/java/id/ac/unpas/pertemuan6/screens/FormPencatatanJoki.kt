package id.ac.unpas.pertemuan6.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.pertemuan6.model.JokiGenshin
import id.ac.unpas.pertemuan6.ui.theme.Purple700
import id.ac.unpas.pertemuan6.ui.theme.Teal200


@Composable
fun FormPencatatanJoki(onSimpan: (JokiGenshin) -> Unit) {
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val uid = remember { mutableStateOf(TextFieldValue("")) }
    val nickname = remember { mutableStateOf(TextFieldValue("")) }
    val objektif = remember { mutableStateOf(TextFieldValue("")) }
    val status = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "Tanggal") },
            value = tanggal.value,
            onValueChange = {
                tanggal.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )
        OutlinedTextField(
            label = { Text(text = "UID") },
            value = uid.value,
            onValueChange = {
                uid.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXXXXXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Nickname") },
            value = nickname.value,
            onValueChange = {
                nickname.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Text),
            placeholder = { Text(text = "xxxxx") }
        )
        OutlinedTextField(
            label = { Text(text = "Objektif") },
            value = objektif.value,
            onValueChange = {
                objektif.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Eksplorasi,dll") }
        )
        OutlinedTextField(
            label = { Text(text = "Status") },
            value = status.value,
            onValueChange = {
                status.value = it
            },
            modifier = Modifier.padding(4.dp).fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Belum dikerjakan / Selesai dikerjakan") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {val item = JokiGenshin(tanggal.value.text, uid.value.text,
                nickname.value.text, objektif.value.text, status.value.text)
                onSimpan(item)
                tanggal.value = TextFieldValue("")
                uid.value = TextFieldValue("")
                nickname.value = TextFieldValue("")
                objektif.value = TextFieldValue("")
                status.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                tanggal.value = TextFieldValue("")
                uid.value = TextFieldValue("")
                nickname.value = TextFieldValue("")
                objektif.value = TextFieldValue("")
                status.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}