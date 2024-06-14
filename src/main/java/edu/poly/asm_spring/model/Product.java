package edu.poly.asm_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "image"}))
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "current_quantity")
	private int currentQuantity;
	
	@Column(name = "cost_price")
	private double costPrice;
	
	@Column(name = "sale_price")
	private double salePrice;
	
	
	@Lob
	@Column(name = "image")
	private String image;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	
	@Column(name = "is_activated")
	private boolean is_activated;
	
	@Column(name = "is_deleted")
	private boolean is_deleted;
}