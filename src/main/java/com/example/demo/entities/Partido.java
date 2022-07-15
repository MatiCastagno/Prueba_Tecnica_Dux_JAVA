package com.example.demo.entities;

import java.util.List;

public class Partido {
	
	private String torneo;
	private String jugador1;
	private String jugador2;
	private Integer cant_sets;
	private Integer probabilidad_J1;
	private Integer probabilidad_J2;
	private Integer sets_J1;
	private Integer sets_J2;
	private List<Integer> lista_Sets_J1;
	private List<Integer> lista_Sets_J2;
	
	public Partido(String torneo, String jugador1, String jugador2, Integer cant_sets, Integer probabilidad_J1,
			Integer probabilidad_J2) {
		super();
		this.torneo = torneo;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.cant_sets = cant_sets;
		this.probabilidad_J1 = probabilidad_J1;
		this.probabilidad_J2 = probabilidad_J2;
		this.sets_J1 = 0;
		this.sets_J2 = 0;
	}

	public Partido() {
		super();
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getJugador1() {
		return jugador1;
	}

	public void setJugador1(String jugador1) {
		this.jugador1 = jugador1;
	}

	public String getJugador2() {
		return jugador2;
	}

	public void setJugador2(String jugador2) {
		this.jugador2 = jugador2;
	}

	public Integer getCant_sets() {
		return cant_sets;
	}

	public void setCant_sets(Integer cant_sets) {
		this.cant_sets = cant_sets;
	}

	public Integer getProbabilidad_J1() {
		return probabilidad_J1;
	}

	public void setProbabilidad_J1(Integer probabilidad_J1) {
		this.probabilidad_J1 = probabilidad_J1;
	}

	public Integer getProbabilidad_J2() {
		return probabilidad_J2;
	}

	public void setProbabilidad_J2(Integer probabilidad_J2) {
		this.probabilidad_J2 = probabilidad_J2;
	}

	public Integer getSets_J1() {
		return sets_J1;
	}

	public void setSets_J1(Integer sets_J1) {
		this.sets_J1 = sets_J1;
	}

	public Integer getSets_J2() {
		return sets_J2;
	}

	public void setSets_J2(Integer sets_J2) {
		this.sets_J2 = sets_J2;
	}

	public List<Integer> getLista_Sets_J1() {
		return lista_Sets_J1;
	}

	public void setLista_Sets_J1(List<Integer> lista_Sets_J1) {
		this.lista_Sets_J1 = lista_Sets_J1;
	}

	public List<Integer> getLista_Sets_J2() {
		return lista_Sets_J2;
	}

	public void setLista_Sets_J2(List<Integer> lista_Sets_J2) {
		this.lista_Sets_J2 = lista_Sets_J2;
	}

	
	
}
