package poo.entities;

import java.time.LocalDate;

public class MeteoData {
	private double degre;
	private LocalDate date;
	
	public MeteoData() {
	}
	
	public MeteoData(LocalDate date, double degre) {
		this.degre = degre;
		this.date = date;
	}

	public double getDegre() {
		return degre;
	}

	public void setDegre(double degre) {
		this.degre = degre;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "MeteoData [degre=" + degre + ", date=" + date + "]";
	}
	
}
