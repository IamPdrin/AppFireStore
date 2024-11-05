package br.edu.fatec.appprodutos.dao

import br.edu.fatec.appprodutos.model.Produto

interface ProdutoDao {
    fun obterFilme(): List<Produto>
}