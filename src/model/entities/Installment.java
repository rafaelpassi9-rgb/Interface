package model.entities;

import java.time.LocalDate;

public class Installment {

	private LocalDate duoDate;
	private Double amount;

	public Installment() {
	}

	public Installment(LocalDate duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
	}

	public LocalDate getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(LocalDate duoDate) {
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return duoDate + " - " + amount;
	}

}
