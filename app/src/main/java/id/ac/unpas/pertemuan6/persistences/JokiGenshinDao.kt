package id.ac.unpas.pertemuan6.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import id.ac.unpas.pertemuan6.model.JokiGenshin

@Dao
interface JokiGenshinDao {
    @Query("SELECT * FROM JokiGenshin")
    fun loadAll(): LiveData<List<JokiGenshin>>
    @Query("SELECT * FROM JokiGenshin WHERE id = :id")
    fun find(id: String): JokiGenshin?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: JokiGenshin)
    @Delete
    fun delete(item: JokiGenshin)
}
}