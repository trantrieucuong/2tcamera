package org.example.ttcameratest.controller.sell;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.product.*;
import org.example.ttcameratest.service.product.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/sell")
@AllArgsConstructor
public class SaleController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final ProductTypeService productTypeService;
    private final ProductDetailService productDetailService;
    private final ImageService imageService;

    @GetMapping("/all")
    public String allProduct(Model model) {
        List<Product>productsSell=productService.findAll();
        List<Category>categories=categoryService.findAll();
        List<ProductType>productTypes=productTypeService.getAllProductTypes();
        model.addAttribute("productsSell",productsSell);
        model.addAttribute("categories",categories);
        model.addAttribute("productTypes",productTypes);

        return "/sell/Index";
    }
    @GetMapping("/search")
    public String search(Model model, @RequestParam String nameProduct) {
        List<Product> productsSell=productService.findByName(nameProduct);
        model.addAttribute("productsSell",productsSell);
        return "/sell/Index";
    }
    @GetMapping("/detail")
    public String detail(Model model, @RequestParam int id, @RequestParam String nameProduct) {
        List<ProductDetailed> productDetaileds = productDetailService.findProductById(id);
        List<Image> imagess = imageService.getImage(id);
        List<Product>nameProducts=productService.findByName(nameProduct);


        model.addAttribute("productDetaileds", productDetaileds);
        model.addAttribute("imagess", imagess);
        model.addAttribute("nameProducts", nameProducts);

        return "/sell/detail";
    }
    @GetMapping("/gioithieu")
    public String gioithieu(Model model) {
      return "/sell/Content/Content";
    }
    @GetMapping("/page")
    public String page(Model model, @RequestParam int page, @RequestParam int size) {
        Page<Product> products=productService.findByPage(page,size);
        model.addAttribute("products",products);
        return "/sell/Index";

    }
}

