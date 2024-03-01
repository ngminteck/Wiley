package com.DTO;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="image")
public class Image {
	
	@Column(name = "image_id", nullable = false)
	private @Id @GeneratedValue Long imageId;
	@Column(name = "image_path", nullable = false)
	private String imagePath;

	public Long getImageId() {
		return imageId;
	}
	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Image [imageId=" + imageId + ", imagePath=" + imagePath + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(imageId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Image other = (Image) obj;
		return Objects.equals(imageId, other.imageId);
	}
	
	

}
