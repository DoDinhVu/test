package edu.poly.asm_spring.service;

import edu.poly.asm_spring.dto.ProductDto;
import edu.poly.asm_spring.dto.ShoppingCartDto;
import edu.poly.asm_spring.model.ShoppingCart;


public interface ShoppingCartService {
	ShoppingCart addItemToCart(ProductDto productDto, int quantity, String username);
	
	ShoppingCart updateCart(ProductDto productDto, int quantity, String username);
	
	ShoppingCart removeItemFromCart(ProductDto productDto, String username);
	
	ShoppingCartDto addItemToCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);
	
	ShoppingCartDto updateCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);
	
	ShoppingCartDto removeItemFromCartSession(ShoppingCartDto cartDto, ProductDto productDto, int quantity);
	
	ShoppingCart combineCart(ShoppingCartDto cartDto, ShoppingCart cart);
	
	void deleteCartById(Long id);
	
	ShoppingCart getCart(String username);
}
