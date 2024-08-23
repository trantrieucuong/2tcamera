package org.example.ttcameratest.controller.sell;

import lombok.AllArgsConstructor;
import org.example.ttcameratest.entity.product.*;
import org.example.ttcameratest.entity.sell.Bill;
import org.example.ttcameratest.entity.sell.Cart;
import org.example.ttcameratest.service.product.*;
import org.example.ttcameratest.service.sell.BillService;
import org.example.ttcameratest.service.sell.CartService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private final BillService billService;
    private final CartService cartService;


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

    @PostMapping("/addbill")
    public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
        Bill savedBill = billService.saveBill(bill);
        return ResponseEntity.ok(savedBill); // Trả về JSON của hóa đơn vừa tạo
    }

//    @PostMapping("/updatebill")
//    public String updateProduct(@ModelAttribute Bill bill) {
//        Bill existingProduct = billService.getBillById(bill.getId());
//        if (existingProduct != null) {
//            existingProduct.setCustomer(bill.getCustomer());
//            existingProduct.setStatus(bill.getStatus());
//            existingProduct.setAddress(bill.getAddress()); // Handle image separately if needed
//            existingProduct.setNumber(bill.getNumber());
//
//            // Ensure date field is not updated if not needed
//            billService.saveBill(existingProduct); // Save the updated product
//        }
//        return "redirect:/api/bill/all";
//    }

    @PostMapping("/addcart")
    public ResponseEntity<Void> addCart(@RequestBody Cart cart) {
        cartService.addCart(cart);
        return ResponseEntity.ok().build();
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
    @GetMapping("/thanhcong")
    public String thanhCong(Model model){
        return "/sell/PaySuccess";
    }
    @GetMapping("/fail")
    public String fail(Model model){
        return "/sell/fail";
    }

}

