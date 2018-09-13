package br.com.ifc.pagarme.model;

public class Resposta {
	private int porta;
	
	private String ip;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private String mensagem;
	
	private String mensagemSistema;

	public String getMensagemSistema() {
		return mensagemSistema;
	}

	public void setMensagemSistema(String mensagemSistema) {
		this.mensagemSistema = mensagemSistema;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}	
}
