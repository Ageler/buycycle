package com.andrewborchenko.spring.buycycle.controllers;

import com.andrewborchenko.spring.buycycle.models.Product;
import com.andrewborchenko.spring.buycycle.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

// отвечает за прием http запросов
// Controller is Component
@Controller
@RequiredArgsConstructor
public class ProductController {

    // если поле помечено как final Spring будет @Autowired автоматически
    // через @RequiredArgsConstructor
    private final ProductService productService;

    // Заменено requiredArgsConstructor
   /* public ProductController(ProductService productService) {
        this.productService = productService;
    }*/

    //главная страница сайта
    // model необходима для передачи параметров в шаблонизатор
    @GetMapping("/")
    // все точно так же берет из url строки
    public String products(@RequestParam(name = "title", required = false) String title,
                           Principal principal, Model model) {
        //название сущность атрибута
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        // название представления
        return "products";
    }

    // адрес post запроса должен совпадать с действием формы
    @PostMapping("/product/create")
    public String createProduct(@RequestParam("file1") MultipartFile file1,
                                @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3,
                                Product product,
                                Principal principal) throws IOException {
        productService.saveProduct(principal, product, file1, file2, file3);
        // return to main page
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
       Product product = productService.getProductById(id);
       model.addAttribute("product", product);
       model.addAttribute("images", product.getImages());
        return "product-info";
    }
}
