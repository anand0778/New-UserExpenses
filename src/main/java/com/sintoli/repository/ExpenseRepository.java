package com.sintoli.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sintoli.entity.Expenses;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses,Long>{
	 Page<Expenses> findByUserIdAndCategory(Long userId,String category, Pageable page);
 
 Page<Expenses> findByUserIdAndNameContaining(Long userId,String keyword,Pageable page);
 
 Page<Expenses> findByUserIdAndDateBetween(Long userId,Date startDate, Date endDate, Pageable page);
 
           Page<Expenses> findByUserId(Long userId,Pageable page);
           
      Optional<Expenses>  findByUserIdAndId(Long userId,Long expensId);
}
