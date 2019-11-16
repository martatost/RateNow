package com.ratenow.provatecnica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Table(name="graphinformation")
public class GraphInformation implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	private Long id;

	@Column
	private int value;

	public GraphInformation() {
	
	}

	public GraphInformation(Long id, int value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "GraphInformation [id=" + id + ", value=" + value + "]";
	}
	
	
	

}
