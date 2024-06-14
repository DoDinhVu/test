package edu.poly.asm_spring.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "delivery_date")
	private Date deliveryDate;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "tax")
	private double tax;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "is_accept")
	private boolean isAccept;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
	private List<OrderDetail> orderDetailList;
	
	@Override
	public String toString() {
		return "Order{" +
				       "id=" + id +
				       ", orderDate=" + orderDate +
				       ", deliveryDate=" + deliveryDate +
				       ", totalPrice=" + totalPrice +
				       ", tax='" + tax + '\'' +
				       ", paymentMethod='" + paymentMethod + '\'' +
				       ", customer=" + customer.getUsername() +
				       ", orderDetailList=" + orderDetailList.size() +
				       '}';
	}
}