package com.org.spring.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Jobs {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotEmpty
	@Column(unique=true)
	@Size(min=10)
	private String description;
	@NotEmpty
	private double budget;
	@NotEmpty
	private Boolean status;
	@NotEmpty
	private String date_finish;
	public String getDate_finish() {
		return date_finish;
	}
	public void setDate_finish(String date_finish) {
		this.date_finish = date_finish;
	}
	@ManyToOne
	@JoinColumn(name="client_id")
	@NotEmpty
	private Client client_id;
	public Client getClient_id() {
		return client_id;
	}
	public void setClient_id(Client client_id) {
		this.client_id = client_id;
	}
	@ManyToOne
	@JoinColumn(name="categoryId")
	@NotEmpty
	private Categories category;
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@NotEmpty
	private Freealancer freelancerId;
	
	public Freealancer getFreelancerId() {
		return freelancerId;
	}
	public void setFreelancerId(Freealancer freelancerId) {
		this.freelancerId = freelancerId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Jobs() {}
	public Jobs(String description, double budget, Boolean status,
			String date_finish, Freealancer freelancerId, Integer id) {
		super();
		this.description = description;
		this.budget = budget;
		this.status = status;
		this.date_finish=date_finish;
		this.freelancerId = freelancerId;
		this.id = id;
	}
}
