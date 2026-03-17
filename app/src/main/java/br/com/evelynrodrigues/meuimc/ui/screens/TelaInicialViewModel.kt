package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.evelynrodrigues.meuimc.model.Pesagem
import br.com.evelynrodrigues.meuimc.repository.PesagemRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class TelaInicialViewModel(
    private val repository: PesagemRepository
): ViewModel() {

    val pesagens: StateFlow<List<Pesagem>> =
        repository.listarPesagens
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

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
