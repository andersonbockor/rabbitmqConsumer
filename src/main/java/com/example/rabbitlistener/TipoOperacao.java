package com.example.rabbitlistener;

public enum TipoOperacao {
	INCLUIR(0, "Novo"), RETIRAR(1, "Pago");

	private final int valor;
	private final String descricao;

	TipoOperacao(int valorOpcao, String descricaoOpcao){
	        valor = valorOpcao;
	        descricao = descricaoOpcao;
	    }

	public int getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}
}
