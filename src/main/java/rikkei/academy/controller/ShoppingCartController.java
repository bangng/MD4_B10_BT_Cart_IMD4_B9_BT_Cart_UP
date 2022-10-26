package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Card;

@Controller

public class ShoppingCartController {
    @ModelAttribute("card")
    public Card setUpCard(){
        return new Card();
    }
    @GetMapping("/shopping-card")
    public ModelAndView showFormCard(@SessionAttribute("card") Card card){
        ModelAndView modelAndView = new ModelAndView("/card");
        modelAndView.addObject("card", card);
        return modelAndView;
    }

}
