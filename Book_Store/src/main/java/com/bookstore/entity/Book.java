package com.bookstore.entity;

import java.util.Locale.Category;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Book Table
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    /**
     * Unique Book Number given by company.
     * Eg: ISBN number
     */
    @Id
    private Long id;

    /**
     * title of the book
     */
    @Column
    private String title;

    /**
     * author of the book
     */
    @Column
    private String author;

    /**
     * category of the book
     * Eg: Novel, Fiction, etc
     */
    @Column
    private Category category;

    /**
     * price of the book
     */
  
    private float price;

    /**
     * Amount of book available
     */
    @Column
    private int totalCount;

    /**
     * Total copies of book sold
     */
    @Column
    private int sold;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}
    
    
}

