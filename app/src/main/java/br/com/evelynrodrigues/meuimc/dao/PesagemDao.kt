package br.com.evelynrodrigues.meuimc.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.evelynrodrigues.meuimc.model.Pesagem
import kotlinx.coroutines.flow.Flow

@Dao
interface PesagemDao {

    // Gravar uma nova pesagem
    @Insert
    suspend fun inserirPesagem(pesagem: Pesagem): Long

    // Listar todas as pesagens ordenadas pelo id
    @Query("SELECT * FROM TB_PESAGEM ORDER BY id ASC")
    fun listarPesagens(): Flow<List<Pesagem>>

    // Buscar uma pesagem pelo id
    @Query("SELECT * FROM TB_PESAGEM WHERE id = :id")
    suspend fun buscarPesagemPorId(id: Int): Pesagem

    // Deletar uma pesagem
    @Delete
    suspend fun deletarPesagem(pesagem: Pesagem): Int

    // Atualizar uma pesagem
    @Update
    suspend fun atualizarPesagem(pesagem: Pesagem): Int

}