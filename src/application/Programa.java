package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.excecoes.DominioExcecoes;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data Entrada (dd/MM/aaaa): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data Saída (dd/MM/aaaa): ");
			Date dataSaida = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Atualizar as datas da reserva: ");
			System.out.print("Data Entrada (dd/MM/aaaa): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data Saída (dd/MM/aaaa): ");
			dataSaida = sdf.parse(sc.next());
			
			
			reserva.atualizarDatas(dataEntrada, dataSaida);
			System.out.println("Reserva atualizada: " + reserva);
		}	
		catch (ParseException e) {
			System.out.println("Formato da data inválido!");
		}
		catch (DominioExcecoes e ) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado!");
		}
		sc.close();
	}

}
