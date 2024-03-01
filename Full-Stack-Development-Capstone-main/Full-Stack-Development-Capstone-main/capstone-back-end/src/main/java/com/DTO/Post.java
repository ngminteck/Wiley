package com.DTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="Post")
public class Post {

	@Column(name = "post_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long postId;
	@Column(name = "title")
	private String title;
	@Column(name = "header", nullable = false)
	private String header;
	@Column(name = "body", nullable = false)
	private String body;
	@Column(name = "post_date", columnDefinition = "DATE", nullable = false)
	private LocalDate postDate;
	@Column(name = "expiry_date", columnDefinition = "DATE" )
	private LocalDate expireDate;

	@Column(name = "is_approved", nullable = false)
	private boolean isApproved;
	
	@Column(name = "account_id", nullable = false)
	private Long userID;
	
	/*
	@Column(name = "category_id", nullable = false)
	private Long categoryID;
	*/

	@ManyToMany
	@JoinTable(name="image",
		joinColumns = {@JoinColumn(name="post_id")})
	private List<Image> images;

	public Post() {

	}
	
	public Post(String title, String header,
			String body, LocalDate postDate,
			LocalDate expireDate, boolean isApproved,
			Long userID) {
	this.title = title;
	this.header = header;
	this.body = body;
	this.postDate = postDate;
	this.expireDate = expireDate;
	this.isApproved = isApproved;
	this.userID =userID;

}
	/*
	public Post(String title, String header,
			String body, LocalDate postDate,
			LocalDate expireDate, boolean isApproved,
			Long userID, Long categoryID) {
	this.title = title;
	this.header = header;
	this.body = body;
	this.postDate = postDate;
	this.expireDate = expireDate;
	this.isApproved = isApproved;
	this.userID =userID;
	this.categoryID = categoryID;
}
	*/
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public LocalDate getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDate postDate) {
		this.postDate = postDate;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean approved) {
		isApproved = approved;
	}
	
	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	/*
	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
*/
	
	@Override
	public String toString() {
		return "Page [postId=" + postId + ", title=" + title + ", header=" + header + ", body=" + body + ", postDate="
				+ postDate + ", ExpireDate=" + expireDate + ", userID=" + userID +  ", catergoryID=" /*+ categoryID*/ +  "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(postId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(postId, other.postId);
	}



   
	
	
}
