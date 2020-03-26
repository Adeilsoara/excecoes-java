package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data Entrada (dd/MM/aaaa): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data Saída (dd/MM/aaaa): ");
		Date dataSaida = sdf.parse(sc.next());
		
		if(!dataSaida.after(dataEntrada)) {
			System.out.println("Erro na reserva: Data de Saída não pode ser menor que a Data"
					+ " de Entrada! ");
		}else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+reserva);
			
			System.out.println();
			System.out.println("Atualizar as datas da reserva: ");
			System.out.print("Data Entrada (dd/MM/aaaa): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data Saída (dd/MM/aaaa): ");
			dataSaida = sdf.parse(sc.next());
			
			
			String erro = reserva.atualizarDatas(dataEntrada, dataSaida);
			
			if(erro != null) {
				System.out.println("Erro na reserva: " +erro);
			}else {
				System.out.println("Reserva atualizada: " + reserva);
			}
				
		}
		sc.close();
	}

}
