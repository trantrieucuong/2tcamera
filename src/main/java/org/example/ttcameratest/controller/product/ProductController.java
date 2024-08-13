package org.example.ttcameratest.controller.product;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.product.Category;
import org.example.ttcameratest.entity.product.Product;
import org.example.ttcameratest.entity.product.ProductType;
import org.example.ttcameratest.service.product.CategoryService;
import org.example.ttcameratest.service.product.ProductService;
import org.example.ttcameratest.service.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductTypeService productTypeService;

    @GetMapping("/all")
    public String allProduct(Model model) {
    List<Product>products=productService.findAll();
    List<Category>categories=categoryService.findAll();
    List<ProductType>productTypes=productTypeService.getAllProductTypes();
    model.addAttribute("products",products);
    model.addAttribute("categories",categories);
    model.addAttribute("productTypes",productTypes);

    return "/product/index";
    }
}
