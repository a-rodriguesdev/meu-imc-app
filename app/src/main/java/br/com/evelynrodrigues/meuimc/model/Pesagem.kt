package br.com.evelynrodrigues.meuimc.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_PESAGEM")
data class Pesagem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val data: String,
    val altura: Double,
    val peso: Double,
    val imc: Double,
    val classificacao: String,
    val cor: String
)