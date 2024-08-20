package org.example.ttcameratest.controller.product;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.product.*;
import org.example.ttcameratest.service.product.*;

import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductTypeService productTypeService;
    private final ProductDetailService productDetailService;
    private final ImageService imageService;

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
    @GetMapping("/page")
    public String page(Model model, @RequestParam int page, @RequestParam int size) {
        Page<Product> products=productService.findByPage(page,size);
        model.addAttribute("products",products);
        return "/product/index";

    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        List<Category>categories=categoryService.findAll();
        List<ProductType>productTypes=productTypeService.getAllProductTypes();
        model.addAttribute("categories",categories);
        model.addAttribute("productTypes",productTypes);
        model.addAttribute("products", new Product());

        return "/product/add";
    }
    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.save(product);
        return "redirect:/api/product/all";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        productService.deleteById(id);
        return "redirect:/api/product/all";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam int id) {
        List<ProductDetailed> productDetaileds = productDetailService.findProductById(id);
        List<Image> imagess = imageService.getImage(id);
        model.addAttribute("productDetaileds", productDetaileds);
        model.addAttribute("imagess", imagess);
        return "/sell/detail";
    }
    @GetMapping("/search")
    public String search(Model model, @RequestParam String nameProduct) {
        List<Product> products=productService.findByName(nameProduct);
        model.addAttribute("products",products);
        return "/product/index";
    }
    @GetMapping("update")
    public String update(Model model, @RequestParam int id) {
        Product product=productService.findById(id);
        List<Category>categories=categoryService.findAll();
        List<ProductType>productTypes=productTypeService.getAllProductTypes();
        model.addAttribute("categories",categories);
        model.addAttribute("productTypes",productTypes);
        model.addAttribute("product",product);
        return "/product/update";
    }
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        Product existingProduct = productService.findById(product.getId());
        if (existingProduct != null) {
            existingProduct.setNameProduct(product.getNameProduct());
            existingProduct.setStatus(product.getStatus());
            existingProduct.setImage(product.getImage()); // Handle image separately if needed
            existingProduct.setCategory(product.getCategory());
            existingProduct.setProductType(product.getProductType());
            // Ensure date field is not updated if not needed
            productService.save(existingProduct); // Save the updated product
        }
        return "redirect:/api/product/all";
    }

//
}
