package com.ratenow.provatecnica.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;



@Entity
@Table (name="testgraph")
public class TestGraph implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	@ElementCollection
	@CollectionTable(name="graphinformation",
					joinColumns = @JoinColumn(name="testgraph_id"))
	private List<Integer> valuesToShow;

	
	
	public TestGraph() {
		super();
	}

	public TestGraph(Long id, String title, List<Integer> valuesToShow) {
		super();
		this.id = id;
		this.title = title;
		this.valuesToShow = valuesToShow;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public List<Integer> getValuesToShow() {
		return valuesToShow;
	}



	public void setValuesToShow(List<Integer> valuesToShow) {
		this.valuesToShow = valuesToShow;
	}



	@Override
	public String toString() {
		return "TestGraph [id=" + id + ", title=" + title + ", valuesToShow=" + valuesToShow + "]";
	}
	
	

}
