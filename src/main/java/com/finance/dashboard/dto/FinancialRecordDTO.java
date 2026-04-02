package com.finance.dashboard.dto;

import com.finance.dashboard.enums.RecordType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class FinancialRecordDTO {

	@NotNull
	private Double amount;

	@NotNull
	private RecordType type;

	private String category;
	private LocalDate date;
	private String notes;

	public FinancialRecordDTO() {
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public RecordType getType() {
		return type;
	}

	public void setType(RecordType type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}