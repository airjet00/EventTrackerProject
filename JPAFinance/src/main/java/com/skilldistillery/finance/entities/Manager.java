package com.skilldistillery.finance.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String username;
	
	private String password;
	
	@Column(name="profile_url")
	private String profileUrl;
	
	private String goal;
	
	@Column(name="goal_achieved")
	private boolean goalAchieved;
	
	@Column(name="total_available")
	private Integer totalAvailable;
	
	@JsonIgnore
	@OneToMany(mappedBy="managerExp")
	private List<Expense> expenses;
	
	@JsonIgnore
	@OneToMany(mappedBy="managerInc")
	private List<Income> incomes;
	
	public Manager() {}

	public Manager(int id, String firstName, String lastName, String username, String password, String profileUrl,
			String goal, boolean goalAchieved, Integer totalAvailable) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.profileUrl = profileUrl;
		this.goal = goal;
		this.goalAchieved = goalAchieved;
		this.totalAvailable = totalAvailable;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public boolean isGoalAchieved() {
		return goalAchieved;
	}

	public void setGoalAchieved(boolean goalAchieved) {
		this.goalAchieved = goalAchieved;
	}

	public Integer getTotalAvailable() {
		return totalAvailable;
	}

	public void setTotalAvailable(Integer totalAvailable) {
		this.totalAvailable = totalAvailable;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
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
		Manager other = (Manager) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manager [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", profileUrl=");
		builder.append(profileUrl);
		builder.append(", goal=");
		builder.append(goal);
		builder.append(", goalAchieved=");
		builder.append(goalAchieved);
		builder.append(", totalAvailable=");
		builder.append(totalAvailable);
		builder.append("]");
		return builder.toString();
	}


	
}
