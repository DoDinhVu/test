package edu.poly.asm_spring.controler;

import edu.poly.asm_spring.dto.ProductDto;
import edu.poly.asm_spring.model.Category;
import edu.poly.asm_spring.model.Product;
import edu.poly.asm_spring.service.CategoryService;
import edu.poly.asm_spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	private final CategoryService categoryService;
	
	
	@GetMapping("/products")
	public String products(Model model) {
		List<ProductDto> products = productService.allProduct();
		model.addAttribute("products", products);
		model.addAttribute("size", products.size());
		return "/products";
	}
	
	@GetMapping("/products/{pageNo}")
	public String allProducts(@PathVariable("pageNo") int pageNo, Model model ) {
		Page<ProductDto> products = productService.getAllProducts(pageNo);
		model.addAttribute("title", "Manage Products");
		model.addAttribute("size", products.getSize());
		model.addAttribute("products", products);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", products.getTotalPages());
		return "/products";
	}
	
	@GetMapping("/search-products/{pageNo}")
	public String searchProduct(@PathVariable("pageNo") int pageNo,
	                            @RequestParam(value = "keyword") String keyword,
	                            Model model
	) {
		
		Page<ProductDto> products = productService.searchProducts(pageNo, keyword);
		model.addAttribute("title", "Result Search Products");
		model.addAttribute("size", products.getSize());
		model.addAttribute("products", products);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", products.getTotalPages());
		return "/products";
		
	}
	
	@GetMapping("/add-product")
	public String addProductPage(Model model) {
		model.addAttribute("title", "Add Product");
		List<Category> categories = categoryService.findAllByActivatedTrue();
		model.addAttribute("categories", categories);
		model.addAttribute("productDto", new ProductDto());
		return "/add-product";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute("productDto") ProductDto product,
	                          @RequestParam("imageProduct") MultipartFile imageProduct,
	                          RedirectAttributes redirectAttributes) {
		try {
			
			productService.save(imageProduct, product);
			redirectAttributes.addFlashAttribute("success", "Add new product successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Failed to add new product!");
		}
		return "redirect:/products/0";
	}
	
	@GetMapping("/update-product/{id}")
	public String updateProductForm(@PathVariable("id") Long id, Model model) {
	
		List<Category> categories = categoryService.findAllByActivatedTrue();
		ProductDto productDto = productService.getById(id);
		model.addAttribute("title", "Add Product");
		model.addAttribute("categories", categories);
		model.addAttribute("productDto", productDto);
		return "/update-product";
	}
	
	@PostMapping("/update-product/{id}")
	public String updateProduct(@ModelAttribute("productDto") ProductDto productDto,
	                            @RequestParam("imageProduct") MultipartFile imageProduct,
	                            RedirectAttributes redirectAttributes) {
		try {
			
			productService.update(imageProduct, productDto);
			redirectAttributes.addFlashAttribute("success", "Update successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Error server, please try again!");
		}
		return "redirect:/products/0";
	}
	
	@RequestMapping(value = "/enable-product", method = {RequestMethod.PUT, RequestMethod.GET})
	public String enabledProduct(Long id, RedirectAttributes redirectAttributes) {
		try {
			productService.enableById(id);
			redirectAttributes.addFlashAttribute("success", "Enabled successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Enabled failed!");
		}
		return "redirect:/products/0";
	}
	
	@RequestMapping(value = "/delete-product", method = {RequestMethod.PUT, RequestMethod.GET})
	public String deletedProduct(Long id, RedirectAttributes redirectAttributes) {
		try {
			productService.deleteById(id);
			redirectAttributes.addFlashAttribute("success", "Deleted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("error", "Deleted failed!");
		}
		return "redirect:/products/0";
	}

}
