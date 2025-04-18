package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
// BI 
@RestController
@RequestMapping("food/")
public class FoodRestController {
   @Autowired
   private FoodService service;
   
   
   
   
}
