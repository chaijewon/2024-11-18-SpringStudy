package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
    @Autowired
    private FoodDAO dao;
    
    @GetMapping("food/list.do")
    public String food_list(String page,Model model)
    {
    	
    	return "food/list";
    }
}
