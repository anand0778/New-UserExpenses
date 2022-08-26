package com.sintoli;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sintoli.entity.Expenses;
import com.sintoli.repository.ExpenseRepository;
import com.sintoli.repository.UserRepository;
import com.sintoli.service.ExpenseService;
import com.sintoli.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserExpenseRestApiApplicationTests {

	@Autowired
	ExpenseService service;
	@Autowired
	ExpenseRepository repository;
	@Test
	public void getAllExpensesTest() {
		List<Expenses> expenses = repository.findAll();
		Assertions.assertThat(expenses.size()).isGreaterThan(0);
	}
}
