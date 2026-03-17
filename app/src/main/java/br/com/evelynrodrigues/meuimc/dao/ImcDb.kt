package br.com.evelynrodrigues.meuimc.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.evelynrodrigues.meuimc.model.Pesagem

@Database(
    entities = [Pesagem::class],
    version = 1
)
abstract class ImcDb : RoomDatabase() {

    abstract fun pesagemDao(): PesagemDao

    companion object {
        private lateinit var instance: ImcDb
        fun getDatabase(context: Context): ImcDb {
            if (!::instance.isInitialized) {
                instance = Room.databaseBuilder(
                    context,
                    ImcDb::class.java,
                    "imc.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}