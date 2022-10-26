package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Card;
import rikkei.academy.model.Product;
import rikkei.academy.service.IProductService;

import java.util.Optional;

@Controller
@SessionAttributes("card")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("card")
    public Card setUpCard(){
        return new Card();
    }
    @GetMapping("/shop")
    public ModelAndView showFormShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCard(@PathVariable Long id, @ModelAttribute Card card,@RequestParam ("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "/error.404";
        }
        if (action.equals("increase")){
            card.addProduct(productOptional.get());
            return "redirect:/shopping-card";
        }else if (action.equals("decrease")){
            card.removeProduct(productOptional.get());
            return "redirect:/shopping-card";
        }
        card.addProduct(productOptional.get());
        return "redirect:/shop";
    }



}
