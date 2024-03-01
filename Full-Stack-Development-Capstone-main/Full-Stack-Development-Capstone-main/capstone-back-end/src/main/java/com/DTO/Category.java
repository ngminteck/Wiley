package com.DTO;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category 
{
	@Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long category_id;
	
	@Column(name = "category_name")
	private String category_name;

	
	public Category(){};

	public Category(String categoryName) {
		this.category_name = categoryName;
	}
	public Long getCategoryId() {
		return category_id;
	}

	public String getCategoryName() {
		return category_name;
	}
	public void setCategoryName(String categoryName) {
		this.category_name = categoryName;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + category_id + ", categoryName=" + category_name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(category_id, other.category_id);
	}
	
	
}
