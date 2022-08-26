package com.sintoli.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sintoli.entity.Expenses;
import com.sintoli.repository.ExpenseRepository;


public interface ExpenseService {

	//ExpenseRepository expenseRepositroy;
	    Page<Expenses> getAllExpenses(Pageable page);
        Expenses getExpenseById(Long id);
        void deleteExpenseById(Long id);
        Expenses   saveExpenseDetails(Expenses expense);
        Expenses updateExpenseDetails(Long id, Expenses expense);
        List<Expenses> readByCategory(String category,Pageable page);
        List<Expenses> readByName(String keyword,Pageable page);
        List<Expenses> readByDate(Date startDate, Date endDate, Pageable page);
}
