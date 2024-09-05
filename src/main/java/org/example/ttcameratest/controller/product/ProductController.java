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
// product
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
        return "/product/detail";
    }
    @GetMapping("/search")
    public String search(Model model, @RequestParam String nameProduct) {
        List<Product> products=productService.findByName(nameProduct);
        model.addAttribute("products",products);
        return "/product/index";
    }
    @GetMapping("/updatedetailproduct")
    public String updatedetailproduct(Model model, @RequestParam int id) {
        ProductDetailed productDetailed = productDetailService.findProductDetailById(id);
        List<Category> categories = categoryService.findAll();
        List<ProductType> productTypes = productTypeService.getAllProductTypes();

        model.addAttribute("productDetailed", productDetailed);
        model.addAttribute("categories", categories);
        model.addAttribute("productTypes", productTypes);

        return "/product/update-detail";
    }

    @PostMapping("/updatedetailproduct")
    public String updatedetailproduct(@ModelAttribute ProductDetailed productDetailed) {
        ProductDetailed existingDetail = productDetailService.findProductDetailById(productDetailed.getId());

        if (existingDetail != null) {
            existingDetail.setDescribe(productDetailed.getDescribe());
            existingDetail.setQuantity(productDetailed.getQuantity());
            existingDetail.setPriceVND(productDetailed.getPriceVND());

            productDetailService.save(existingDetail); // Save the updated product detail
        }

        return "redirect:/api/product/detail?id=" + productDetailed.getProduct().getId();
    }



//
}
