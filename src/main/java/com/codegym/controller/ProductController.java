package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("product")
public class ProductController {

    IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView showProductList(){
        ModelAndView mav = new ModelAndView("product");
        mav.addObject("products",productService.findAll());
        return mav;
    }


    @GetMapping("create")
    public ModelAndView showCreateProductForm(){
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("product",new Product());
        return mav;
    }
    @PostMapping("save")
    public ModelAndView saveProduct(Product product){
        ModelAndView mav = new ModelAndView("redirect:/product");
        product.setId(productService.findMaxId());
        productService.save(product);
        return mav;
    }

    @GetMapping("{id}/edit")
    public ModelAndView showEditProductForm(@PathVariable int id){
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("product",productService.findById(id));
        return mav;
    }
    @PostMapping("edit")
    public ModelAndView editProduct(Product product){
        ModelAndView mav = new ModelAndView("redirect:/product");
        productService.update(product.getId(),product);
        return mav;
    }

    @GetMapping("{id}/delete")
    public ModelAndView showDeleteFrom(@PathVariable int id){
        ModelAndView mav = new ModelAndView("delete");
        mav.addObject("product",productService.findById(id));
        mav.addObject("message","Are you sure?");
        return mav;
    }
    @PostMapping("delete")
    public String deleteProduct(Product product, RedirectAttributes redirect){
        productService.delete(product.getId());
        redirect.addFlashAttribute("message","Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("{id}/detail")
    public ModelAndView detailProduct(@PathVariable int id){
        ModelAndView mav = new ModelAndView("detail");
        mav.addObject("product",productService.findById(id));
        return mav;
    }

    @GetMapping("search")
    public ModelAndView searchByProductName(String name){
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("products",productService.findByName(name));
        return mav;
    }

}
