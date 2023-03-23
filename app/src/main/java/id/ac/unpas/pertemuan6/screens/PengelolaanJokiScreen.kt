package id.ac.unpas.pertemuan6.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.ac.unpas.pertemuan6.model.JokiGenshin
import id.ac.unpas.pertemuan6.persistences.JokiGenshinDao


@Composable
fun FormPencatatanJoki(jokiGenshinDao){
    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pengelolaan-joki"
    ).build()
    val jokiGenshinDao = db.jokiGenshinDao()

    val list : LiveData<List<JokiGenshin>> = jokiGenshinDao.loadAll()
    val items: List<JokiGenshin> by list.observeAsState(initial = listOf())
    Column(modifier = Modifier.fillMaxWidth()) {
        FormPencatatanJoki()
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = items, itemContent = { item ->
                Row(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal", fontSize = 14.sp)
                        Text(text = item.tanggal, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "UID", fontSize = 14.sp)
                        Text(text = item.uid, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nickname", fontSize = 14.sp)
                        Text(text = item.nickname, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Objektif", fontSize = 14.sp)
                        Text(text = item.objektif, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Status", fontSize = 14.sp)
                        Text(text = item.status, fontSize = 16.sp, fontWeight =
                        FontWeight.Bold)
                    }
                    Divider(modifier = Modifier.fillMaxWidth())
                }
            })
        }
    }
}