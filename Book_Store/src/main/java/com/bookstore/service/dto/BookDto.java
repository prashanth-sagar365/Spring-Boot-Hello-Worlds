package com.bookstore.service.dto;

import com.bookstore.constants.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    /**
     * Unique Book Number given by company.
     * Eg: ISBN number
     */
  // @ApiModelProperty(value="Book Unique Id")
    private Long id;

    /**
     * title of the book
     */
    //@ApiModelProperty(value="Title of the book")
    private String title;

    /**
     * author of the book
     */
   // @ApiModelProperty(value="Author of the book")
    private String author;

    /**
     * category of the book
     * Eg: Novel, Fiction, etc
     */
  // @ApiModelProperty(value="Category of the book")
    private Category category;

    /**
     * price of the book
     */
   // @ApiModelProperty(value = "Price of the book")
  //  @Min(value = 0, message = "Price should be positive value.")
    private float price;

    /**
     * Amount of book available
     */
   // @ApiModelProperty(value="Copies of book available on the store")
  //  @Min(value = 0, message = "Total Count should be positive value.")
    private int totalCount;

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
    
    


}
