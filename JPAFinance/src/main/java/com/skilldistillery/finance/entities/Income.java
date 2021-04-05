package com.skilldistillery.finance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Income {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private int total;

	@Column(name="is_passive")
	private boolean isPassive;
	
	@Column(name="date_created")
	private String dateCreated;
	
	@Column(name="is_active")
	private boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name="manager_id_inc")
	private Manager managerInc;
	
	public Income() {}

	public Income(int id, String description, int total, boolean isPassive, String dateCreated, boolean isActive,
			Manager managerInc) {
		super();
		this.id = id;
		this.description = description;
		this.total = total;
		this.isPassive = isPassive;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
		this.managerInc = managerInc;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isPassive() {
		return isPassive;
	}

	public void setPassive(boolean isPassive) {
		this.isPassive = isPassive;
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

	public Manager getManagerInc() {
		return managerInc;
	}

	public void setManagerInc(Manager managerInc) {
		this.managerInc = managerInc;
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
		Income other = (Income) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Income [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append(", total=");
		builder.append(total);
		builder.append(", isPassive=");
		builder.append(isPassive);
		builder.append(", dateCreated=");
		builder.append(dateCreated);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(".");
		return builder.toString();
	}
}
