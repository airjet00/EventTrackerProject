package com.skilldistillery.finance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Expense {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String type;
	
	private String company;
	
	private Integer amount;
	
	@Column(name="due_date")
	private String dueDate;
	
	@Column(name="is_reacurring")
	private boolean isReacurring;
	
	private String note;
	
	@Column(name="date_created")
	private String dateCreated;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="manager_id_exp")
	private Manager managerExp;
	
	public Expense() {}

	public Expense(int id, String type, String company, Integer amount, String dueDate, boolean isReacurring,
			String note, String dateCreated, boolean isActive, Manager manager) {
		super();
		this.id = id;
		this.type = type;
		this.company = company;
		this.amount = amount;
		this.dueDate = dueDate;
		this.isReacurring = isReacurring;
		this.note = note;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
		this.managerExp = manager;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public boolean isReacurring() {
		return isReacurring;
	}


	public void setReacurring(boolean isReacurring) {
		this.isReacurring = isReacurring;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Manager getManagerExp() {
		return managerExp;
	}


	public void setManagerExp(Manager managerExp) {
		this.managerExp = managerExp;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Expense id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append(", company=");
		builder.append(company);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", isReacurring=");
		builder.append(isReacurring);
		builder.append(", note=");
		builder.append(note);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(".");
		return builder.toString();
	}
	

}
