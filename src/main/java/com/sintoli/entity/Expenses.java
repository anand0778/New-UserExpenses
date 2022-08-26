package com.sintoli.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_expenses")
public class Expenses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
	@Column(name="expense_name")
@NotBlank(message="Expense name must not be Null")
@Size(min=3, message="Expense name must be 3 character")
private String name;
	
private String description;
@Column(name="expense_amount")
private BigDecimal amount;
private String category;
private Date date;


@Column(name="crated_at",nullable=false, updatable=false)
@CreationTimestamp
private Timestamp createdAt;

@Column(name="updated_at")
@UpdateTimestamp
private Timestamp updatedAt;

@ManyToOne(fetch=FetchType.LAZY, optional=false)
@JoinColumn(name="user_id", nullable=false)
@OnDelete(action=OnDeleteAction.CASCADE)
@JsonIgnore
private User user;
}
