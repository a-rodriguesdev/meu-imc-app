package br.com.evelynrodrigues.meuimc.repository

import br.com.evelynrodrigues.meuimc.dao.PesagemDao
import br.com.evelynrodrigues.meuimc.model.Pesagem
import kotlinx.coroutines.flow.Flow

class PesagemRepository(private val pesagemDao: PesagemDao) {

    // Gravar uma nova pesagem
    suspend fun inserirPesagem(pesagem: Pesagem): Long {
        return pesagemDao.inserirPesagem(pesagem)
    }

    // Listar todas as pesagens ordenadas pelo id
    val listarPesagens: Flow<List<Pesagem>> = pesagemDao.listarPesagens()

    // Buscar uma pesagem pelo id
    suspend fun buscarPesagemPorId(id: Int): Pesagem {
        return pesagemDao.buscarPesagemPorId(id)
    }

    // Deletar uma pesagem
    suspend fun deletarPesagem(pesagem: Pesagem): Int {
        return pesagemDao.deletarPesagem(pesagem)
    }

    // Atualizar uma pesagem
    suspend fun atualizarPesagem(pesagem: Pesagem): Int {
        return pesagemDao.atualizarPesagem(pesagem)
    }
}