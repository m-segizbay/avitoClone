package kz.segizbay.buysell.controllers;

import kz.segizbay.buysell.Services.ProductService;
import kz.segizbay.buysell.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProdjuctController {
    private final ProductService productService;

    @GetMapping("/")
    public String product(@RequestParam(name="title", required = false) String title, Model model){
        model.addAttribute("products", productService.getProducts(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        return "product_info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam(name = "file1") MultipartFile file1,
                                @RequestParam(name = "file2") MultipartFile file2,
                                @RequestParam(name = "file3") MultipartFile file3, Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
