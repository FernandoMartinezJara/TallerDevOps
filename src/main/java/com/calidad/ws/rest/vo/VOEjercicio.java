package com.calidad.ws.rest.vo;

public class VOEjercicio {

	private String pregunta;
	private String codigo;
	private int idejercicio;
	
	public int getIdejercicio(){
		return idejercicio;
	}
	public void setIdejercicio(int idejercicio){
		this.idejercicio=idejercicio;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String fuente) {
		this.codigo = fuente;
	}	
	
}
