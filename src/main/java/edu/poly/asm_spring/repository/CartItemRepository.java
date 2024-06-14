package edu.poly.asm_spring.repository;

import edu.poly.asm_spring.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	@Query(value = "update CartItem c set c.product.id = null where c.cart.id = ?1")
	void deleteCartItemById(Long cartId);
}
