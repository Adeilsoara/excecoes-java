package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	public Reserva(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public long permanencia() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atualizarDatas(Date dataEntrada, Date dataSaida) {
		Date agora = new Date();
		if (dataEntrada.before(agora) || dataSaida.before(agora)) {
			return "Erro na Reserva: As datas precisam ser futuras. ";
		
		}
		if(!dataSaida.after(dataEntrada)) {
			return "Erro na reserva!";
		}
		
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		
		return null;
	}
	
	public String toString() {
		return "Número quarto: " 
				+ numeroQuarto 
				+ ", Data Entrada: "
				+ sdf.format(dataEntrada)
				+ ", Data Saída: "
				+ sdf.format(dataSaida)
				+ ", "
				+ permanencia()
				+ " Noites";
	}
	
	
}
