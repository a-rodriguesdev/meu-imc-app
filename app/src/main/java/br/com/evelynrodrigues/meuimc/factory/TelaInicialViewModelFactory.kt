package br.com.evelynrodrigues.meuimc.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.evelynrodrigues.meuimc.repository.PesagemRepository
import br.com.evelynrodrigues.meuimc.ui.screens.TelaInicialViewModel

class TelaInicialViewModelFactory(
    private val repository: PesagemRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(TelaInicialViewModel::class.java)) {
            return TelaInicialViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}