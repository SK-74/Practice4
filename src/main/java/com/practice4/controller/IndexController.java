package com.practice4.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@GetMapping("/")
	public String index(@RequestParam(required = false, name = "value")Integer val, Model model) {
		if(Objects.nonNull(val)) {	
			String message = val + "は、";
			
			boolean result = over100(val);
			if(result) {
				message += "100より大きい数字でした";
			}else {
				message += "100以下の数字でした";
			}
			//Thymeleafに情報を渡す。htmlファイルに${message}が必要
			model.addAttribute("message", message);
			//Thymeleafに情報を渡す。htmlファイルに${val}が必要
			model.addAttribute("val", val);
		}
		//htmlファイルの名前を返却
		return "index";
	}

	private boolean over100(int val) {
		boolean result = false;
		if(val > 100) {
			result = true;
		}
		return result;
	}
}
