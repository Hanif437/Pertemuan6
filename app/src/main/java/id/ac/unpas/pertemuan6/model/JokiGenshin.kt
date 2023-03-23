package id.ac.unpas.pertemuan6.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class JokiGenshin(
    @PrimaryKey val id : String,
    val tanggal: String,
    val uid : String,
    val nickname : String,
    val objektif : String,
    val status : String
)
