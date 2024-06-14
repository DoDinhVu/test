package edu.poly.asm_spring.repository;

import edu.poly.asm_spring.model.Order;
import edu.poly.asm_spring.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	@Query("select o from Order o where o.customer.id = ?1")
	List<Order> findAllByCustomerId(Long id);
}
