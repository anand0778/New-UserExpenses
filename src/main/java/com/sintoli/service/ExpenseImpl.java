package com.sintoli.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sintoli.entity.Expenses;
import com.sintoli.exception.ResourceNotFoundException;
import com.sintoli.repository.ExpenseRepository;

@Service
public class ExpenseImpl implements ExpenseService {

	@Autowired
	private UserService userService;
	@Autowired
	private ExpenseRepository expenseRepo;
	public Page<Expenses> getAllExpenses(Pageable page) {
		
		return expenseRepo.findByUserId(userService.getLoggedInUser().getId(),page);
	}
	@Override
	public Expenses getExpenseById(Long id) {
		// TODO Auto-generated method stub
		Optional<Expenses> expense=expenseRepo.findByUserIdAndId(userService.getLoggedInUser().getId(),id);
		if(expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense is not found for the id "+id);
	}
	@Override
	public void deleteExpenseById(Long id) {
		      Expenses expense=getExpenseById(id);
		      expenseRepo.delete(expense);
		}
	@Override
	public Expenses saveExpenseDetails(Expenses expense) {
	expense.setUser(userService.getLoggedInUser());
		return expenseRepo.save(expense);
	}
	@Override
	public Expenses updateExpenseDetails(Long id, Expenses expense) {
		        Expenses existingExpense= getExpenseById(id);
existingExpense.setName(expense.getName()!=null ? expense.getName(): existingExpense.getName());
existingExpense.setDescription(expense.getDescription()!=null ? expense.getDescription():existingExpense.getDescription());		
existingExpense.setCategory(expense.getCategory()!=null ? expense.getCategory():existingExpense.getCategory());
existingExpense.setAmount(expense.getAmount()!=null ? expense.getAmount():existingExpense.getAmount());
existingExpense.setDate(expense.getDate()!=null ? expense.getDate():existingExpense.getDate());
return expenseRepo.save(existingExpense);
	}
	@Override
	public List<Expenses> readByCategory(String category, Pageable page) {
	
		return expenseRepo.findByUserIdAndCategory(userService.getLoggedInUser().getId(),category, page).toList();
	}
	@Override
	public List<Expenses> readByName(String keyword, Pageable page) {
	             return expenseRepo.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(),keyword, page).toList();
		
	}
	@Override
	public List<Expenses> readByDate(Date startDate, Date endDate, Pageable page) {
		if(startDate==null) {
			startDate=new Date(0);
		}
		if(endDate==null) {
			endDate=new Date(System.currentTimeMillis());
		}
		Page<Expenses> pages=expenseRepo.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(),startDate, endDate, page);
		return pages.toList();
	}

}
