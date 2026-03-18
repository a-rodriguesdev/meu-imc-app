package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.evelynrodrigues.meuimc.model.Pesagem
import br.com.evelynrodrigues.meuimc.ui.theme.MeuIMCTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaInicial(viewModel: TelaInicialViewModel) {

    val pesagens by viewModel.pesagens.collectAsStateWithLifecycle()

    val telaAtual = viewModel.telaAtual.value

    var pesagemParaExcluir by remember { mutableStateOf<Pesagem?>(null) }

    Scaffold(
        modifier = Modifier
            .background(color = Color.LightGray),
        topBar = {
            TopAppBar(
                title = {
                    Column() {
                        Text(
                            text = "Meu IMC",
                        )
                        Text(
                            text = "Dashboard",
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
            )
        },
        floatingActionButton = {
            if (telaAtual is Screen.ListaPesagens){
                FloatingActionButton(
                    onClick = {
                        viewModel.abrirFormularioPesagem()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Nova pesagem"
                    )
                }
            }

        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.LightGray)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                when (telaAtual){
                    is Screen.FormularioPesagem -> FormularioPesagem(
                        onCancelar = {
                            viewModel.abrirListaPesagens()
                        },
                        onRegistrarPeso = {pesagem ->
                            viewModel.inserirPesagem(pesagem)
                            viewModel.abrirListaPesagens()
                        }
                    )
                    is Screen.ListaPesagens -> ListaPesagens(
                        pesagens,
                        onDelete = {
                            pesagemParaExcluir = it
                        }
                    )
                }
            }
        }
    }

    if (pesagemParaExcluir != null) {
        val pesagem = pesagemParaExcluir!!
        AlertDialog(
            onDismissRequest = { pesagemParaExcluir = null },
            title = { Text(text = "Excluir pesagem") },
            text = {
                Text(text = "Tem certeza que deseja excluir esta pesagem?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.excluirPesagem(pesagem)
                        pesagemParaExcluir = null
                    }
                ) {
                    Text(text = "Excluir")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { pesagemParaExcluir = null }
                ) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TelaInicialPreview() {
    MeuIMCTheme() {
        //TelaInicial(viewModel = TelaInicialViewModel)
    }
}