package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TelaInicialViewModel: ViewModel() {

    private val _telaAtual = mutableStateOf<Screen>(Screen.ListaPesagens)
    val telaAtual: State<Screen>
        get() = _telaAtual

    init {
        abrirListaPesagens()
    }

    fun abrirFormularioPesagem(){
        _telaAtual.value = Screen.FormularioPesagem
    }

    fun abrirListaPesagens(){
        _telaAtual.value = Screen.ListaPesagens
    }

}
