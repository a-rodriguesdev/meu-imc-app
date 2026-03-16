package br.com.evelynrodrigues.meuimc.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.evelynrodrigues.meuimc.ui.theme.MeuIMCTheme

@Composable
fun FormularioPesagem(onCancelar : () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .safeContentPadding()
    ) {
        Text(
            text = "Nova pesagem",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Informe seus dados",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(48.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Data da pesagem")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Altura")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Peso")
            }
        )
        Spacer(modifier = Modifier.height(48.dp))
        Button (
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Registrar peso")
        }
        Spacer(modifier = Modifier.height(48.dp))
        TextButton(
            onClick = { onCancelar() },
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Cancelar e Voltar")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun FormularioPesagemPreview() {
    MeuIMCTheme {
        FormularioPesagem( onCancelar = { })
    }
}