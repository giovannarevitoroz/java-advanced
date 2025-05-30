package com.fiap.exemploLombok.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@data gera @Getter @NoArgsConstructor, @AllArgsConstructor, @Setter e @EqualsAndHashCode.
@NoArgsConstructor // construtor sem argumentos
@AllArgsConstructor // com todos os argumentos
public class Pedido {
	
	private Long id;
	private String nome;
	private double preco;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
