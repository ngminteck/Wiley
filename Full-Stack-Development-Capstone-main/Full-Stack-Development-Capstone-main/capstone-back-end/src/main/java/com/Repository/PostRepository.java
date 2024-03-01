package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
    List<Post> findByIsApproved(boolean b);
    @Query(value = "SELECT p.* FROM Post p" +
            "JOIN PostCategory pc ON pc.post_id = p.post_id" +
            "JOIN Category c ON c.category_id = pc.category_id" +
            "WHERE is_approved = true AND c.category_name like ?1", nativeQuery = true)
    List<Post> findByCategory(String categoryName);
	
}
