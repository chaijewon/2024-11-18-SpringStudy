package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
    @GetMapping("food/list.do")
    public String food_list()
    {
    	return "food/list";
    }
    @GetMapping("goods/list.do")
    public String goods_list()
    {
    	return "goods/list";
    }
    @GetMapping("goods/detail.do")
    public String goods_detail(int no,Model model)
    {
    	model.addAttribute("no", no); // ${param.no}
    	return "goods/detail";
    }
}
