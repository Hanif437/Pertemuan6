package id.ac.unpas.pertemuan6.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.functionalcompose.model.JokiGenshin

@Database(entities = [JokiGenshin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun jokiGenshinDao(): JokiGenshinDao
}