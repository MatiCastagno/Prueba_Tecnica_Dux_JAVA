package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Partido;
import com.example.demo.services.PartidoService;

@SpringBootApplication
public class PartidoTenis1Application {

	private static Scanner read;

	public static void main(String[] args) {
		SpringApplication.run(PartidoTenis1Application.class, args);
		
		read = new Scanner(System.in);
		Boolean revancha = false;
		
		

		System.out.print("\nORGANIZA TU PARTIDO DE TENIS!!");
		
		System.out.print("\nINGRESA LOS SIGUIENTES DATOS: ");
		
		System.out.print("\nNOMBRE DEL TORNEO: ");
		String torneo = read.nextLine();
		
		System.out.print("NOMBRE DEL JUGADOR UNO: ");
		String jugador1 = read.nextLine();
		
		System.out.print("NOMBRE DEL JUGADOR DOS: ");
		String jugador2 = read.nextLine();
		
		System.out.print("CANTIDAD DE SET'S A JUGAR (3 o 5): ");
		int cantS = read.nextInt();
		
		System.out.print("PROBABILIDAD DE GANAR DEL JUGADOR UNO: ");
		int p_j1 = read.nextInt();
		
		System.out.print("PROBABILIDAD DE GANAR DEL JUGADOR DOS: ");
		int p_j2 = read.nextInt();
		
		
		
		//Partido partido = new Partido(torneo, jugador1, jugador2, cantS, p_j1, p_j2);
		Partido partido = PartidoService.create(torneo, jugador1, jugador2, cantS, p_j1, p_j2);
		PartidoService.arrancaPartido(partido);
		
		System.out.print("\nesteQUIERES JUGAR LA REVANCHA? :");
		
		String rta2 = read.nextLine();
		String rta = read.nextLine();
		
		if(rta.equalsIgnoreCase("si")) {
			revancha = true;
		}else {
			revancha = false;
		}

		while (revancha) {
			
			PartidoService.arrancaPartido(partido);
			
			System.out.print("\nQUIERES JUGAR LA REVANCHA?");
			String rta1 = read.nextLine().toLowerCase();
			
			if(rta1.equalsIgnoreCase("si")) {
				revancha = true;
			}else {
				revancha = false;
			}
		}
			
		
}

}
