package com.jlearn.Spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="topic details")
@Entity
@Table(name="TOPIC")
public class Topic {
	
	@Id
	private String id;
	
	@Size(min=4, message="name should have alteast 4 characters.")
	@NotEmpty
	@ApiModelProperty(notes="name must have atleast 4 charactesrs.")
	@Column
	private String name;
	
	@Column
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
