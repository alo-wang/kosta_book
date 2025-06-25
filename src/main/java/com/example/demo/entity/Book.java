package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	private int no;
	private String title;
	private int price;
	private int qty;
	private String publisher;
}
