package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DTO.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

//    @Query(value = "SELECT category_id from CATEGORY where category_name like ?1", nativeQuery = true)
//    Long getCategoryId(String category);
}
