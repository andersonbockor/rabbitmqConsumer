package com.example.rabbitlistener;

//import java.io.Serializable;

public class CustomMessage {

	//private static final long serialVersionUID = 1L;
	private TipoOperacao tipo;
    private Integer id;
    private String bomba;
    private Double valor;

    public CustomMessage() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "tipo='" + tipo.getValor() + '\'' +
                "id='" + id + '\'' +
                "bomba='" + bomba + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getBomba() {
		return bomba;
	}

	public void setBomba(String bomba) {
		this.bomba = bomba;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
