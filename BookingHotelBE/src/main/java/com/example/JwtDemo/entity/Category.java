package com.example.JwtDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "category_room")
    private String categoryName;
    
    @Column(name = "price")
    private String price;
    
    @Column(name = "bed")
    private String bed;

    @Column(name = "refrigerator")
    private String refrigerator;
    
    @Column(name = "television")
    private String television;
    
    @Column(name = "bathtub")
    private String bathtub;
    
    @Column(name = "hairdryer")
    private String hairdryer;
    
    @Column(name = "airConditioner")
    private String airConditioner;
    
    @Column(name = "deskWork")
    private String deskWork;
    
    @Column(name = "safe")
    private String safe;
    
    @Column(name = "dressingTable")
    private String dressingTable;
    
    @Column(name = "miniBar")
    private String miniBar;
    
    @Column(name = "coffeeMaker")
    private String coffeeMaker;
    
    @Column(name = "microwaveOven")
    private String microwaveOven;
}
