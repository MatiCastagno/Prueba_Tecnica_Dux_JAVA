package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entities.Partido;

public class PartidoService {
	
		public static Partido create (String torneo, String nombre1, String nombre2, Integer cant_sets, Integer p_J1, Integer p_J2) {
			
			Partido newPartido = new Partido();
			
			newPartido.setTorneo(torneo);
			newPartido.setJugador1(nombre1);
			newPartido.setJugador2(nombre2);
			newPartido.setCant_sets(cant_sets);
			newPartido.setProbabilidad_J1(p_J1);
			newPartido.setProbabilidad_J2(p_J2);
			newPartido.setSets_J1(0);
			newPartido.setSets_J2(0);
			
			System.out.print("\nPARTIDO CREADO CON EXITO!");
			
			return newPartido;
		}
		
		public static void arrancaPartido (Partido partido) {
			
			//guardamos las probabilidades de ganar en variables locales
			
			Integer p1 = partido.getProbabilidad_J1();
			Integer p2 = partido.getProbabilidad_J2();
			List<Integer> list_j1 = new ArrayList<>();
			List<Integer> list_j2 = new ArrayList<>();
			
			
			// arranca el partido :s
			
			System.out.print("\nARRANCA EL PARTIDO, GANA EL MEJOR A " + partido.getCant_sets() + " SETS!");
			System.out.print("\nJ1: " + partido.getJugador1() + ": 0");
			System.out.print("\nJ2: " + partido.getJugador2() + ": 0");
			
			for (int i = 1; i < partido.getCant_sets(); i++) {
				
				System.out.print("\nARRANCA EL SET Nro: " + i);
				
				//cantidad de juegos para conseguir el set
				Integer juegos_j1 = 0;
				Integer juegos_j2 = 0;
				
				while (juegos_j1 < 6 && juegos_j2 < 6) {
					
					System.out.print("\nJUEGOS " + partido.getJugador1() + ": " + juegos_j1);
					System.out.print("\nJUEGOS " + partido.getJugador2() + ": " + juegos_j2);
					
					int rta = juegoX(p1, partido);
					
					if (rta == 0) {
						if(juegos_j1 < 6) {
							juegos_j1 += 1;
						}
					
					}else {
						if(juegos_j2 < 6) {
						juegos_j2 += 1;
						}
					}

					//analizar que pasa si quedan igualados en 6 juegos cada uno
					
					if (juegos_j1 == 6 && juegos_j2 == 6) {

						int rta1 = setEmpatado(p1, partido);					

						if (rta1 == 0) {
							partido.setSets_J1(partido.getSets_J1() + 1);
							break;
						} else {
							partido.setSets_J2(partido.getSets_J2() + 1);
							break;
						}
					} 
					
				}	
				
				//guardamos los juegos de cada jugador conseguidos en cada set
				
				int aux1 = juegos_j1;
				int aux2 = juegos_j2;
				
				list_j1.add(aux1); 
				list_j2.add(aux2);
				
				 if (juegos_j1 >= 6 && juegos_j2 < 6) {
					  
					partido.setSets_J1(partido.getSets_J1() + 1);
					
				} else  if (juegos_j2 >= 6 && juegos_j1 <6){
					
					partido.setSets_J2(partido.getSets_J2() + 1);
			}	
			
				 //un resultado parcial de los set de cada jugador
			System.out.print("\nSETS " + partido.getJugador1() + ": " + partido.getSets_J1());
			System.out.print("\nSETS " + partido.getJugador2() + ": " + partido.getSets_J2());
		
			
			
		}			

			//vemos quien gano y mostramos el resultado
			if(partido.getSets_J1() > partido.getSets_J2()) {
				
				System.out.print("\n FINAL DEL TORNEO " + partido.getTorneo().toUpperCase());
				System.out.print("\nGANADOR DEL PARTIDO: " + partido.getJugador1());
				System.out.print("\n" + partido.getJugador1() + list_j1.toString());
				System.out.print("\n" + partido.getJugador2() + list_j2.toString());
				
			}else {
				System.out.print("\n FINAL DEL TORNEO " + partido.getTorneo().toUpperCase());
				System.out.print("\nGANADOR DEL PARTIDO: " + partido.getJugador2());
				System.out.print("\n" + partido.getJugador2() + list_j2.toString());
				System.out.print("\n" + partido.getJugador1() + list_j1.toString());
				
			}
			
			
		}
		
		public static int juegoX (Integer p1, Partido partido) {
			
			// arranca un juego
			int ganador= 0; //retorna como 0 si gana j1 o retorna como 1 si gana j2
			
			//puntos de cada juego 
			Integer puntos_j1 = 0;
			Integer puntos_j2 = 0;

			while (puntos_j1 < 55 && puntos_j2 < 55) {

				System.out.print("\n" + partido.getJugador1() + ": puntos -> " + puntos_j1);
				System.out.print("\n" + partido.getJugador2() + ": puntos -> " + puntos_j2);
				
				int pto = (int)(Math.random()*100);

				if (pto > 0 && pto <= p1) {
					if(puntos_j1 == 30) {
						puntos_j1 += 10;
					}else {
						puntos_j1 += 15;
					}

				} else {
					if(puntos_j2 == 30) {
						puntos_j2 += 10;
					}else {
						puntos_j2 += 15;
					}
				}

				if (puntos_j1 == 40 && puntos_j2 == 40) {

					System.out.print("\nJuego empatado en 40, gana el que consigue una ventaja de 2");
					
					int rta = juegoEmpatado(p1, partido);

					if (rta == 0) {
						ganador = 0;
						break;
					} else {
						ganador = 1;
						break;
					}
				}  
				
			}
			
			if (puntos_j1 >= 40 && puntos_j2 < 40) {
				ganador = 0;
			} else if (puntos_j2 >= 40 && puntos_j1 < 40){
				ganador = 1;
			}
			
			return ganador;
		}
		
		
		public static int juegoEmpatado(Integer p1, Partido partido) {
			
			int ventaja_j1 = 0; 
			int ventaja_j2 = 0; 
			int rta = 3;
			
			while(ventaja_j1 < 2 && ventaja_j2 < 2) {
				
				System.out.print("\n" + partido.getJugador1() + " ventaja -> " + ventaja_j1);
				System.out.print("\n" + partido.getJugador2() + " ventaja -> " + ventaja_j2);
				
				int pnto = (int)(Math.random()*100);
				
				if(pnto > 0 && pnto <= p1 ) {
					ventaja_j1 += 1;
					if(ventaja_j2 == 1) {
						ventaja_j2 -= 1;
					}
				}else {
					ventaja_j2 += 1;
					if(ventaja_j1 == 1) {
						ventaja_j1 -= 1;
					}
				}
			}
			
			System.out.print("\n" + partido.getJugador1() + ": puntos -> " + ventaja_j1);
			System.out.print("\n" + partido.getJugador2() + ": puntos -> " + ventaja_j2);
			
			if(ventaja_j1 == 2) {				
				rta = 0;
			} else if(ventaja_j2 == 2){
				rta = 1;
			}
			return rta;
		}
		
		
		public static int setEmpatado(Integer p1, Partido partido) {

			// SE JUEGA UN TIE BREAK A 7 CON DIF. DE DOS

			System.out.print("\nJuego empatado en 6 juegos, arranca el tie break: ");

			int rta = 3;
			int puntosJ1 = 0;
			int puntosJ2 = 0;
			
			System.out.print("\n" + partido.getJugador1() + " puntos -> " + puntosJ1);
			System.out.print("\n" + partido.getJugador2() + " puntos -> " + puntosJ2);

			while (puntosJ1 < 7 && puntosJ2 < 7) {


				int pnto = (int)(Math.random()*100);

				if (pnto > 0 && pnto < p1) {
					puntosJ1 += 1;

				} else {
					puntosJ2 += 1;
				}

				// POSIBILIDAD DE 6-6
				if (puntosJ1 == 6 && puntosJ2 == 6) {

					rta = juegoEmpatado(p1, partido);

				}

				
				
				System.out.print("\n" + partido.getJugador1() + " puntos -> " + puntosJ1);
				System.out.print("\n" + partido.getJugador2() + " puntos -> " + puntosJ2);
			}
			
			if (puntosJ1 == 7) {
				rta = 0;
			} else if (puntosJ2 == 7) {
				rta = 1;
			}
			
			return rta;
		}

}
