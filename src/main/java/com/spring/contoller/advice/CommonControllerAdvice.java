package com.spring.contoller.advice;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.spring.contoller.ShowController;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/*标识控制器通知，并且指定对应的包
SpringMVC 能够给控制器加入通知 它主要涉及 个注解：
• ControllerAdvice 主要作用于类，用以标识全局性的控制器的拦截器，它将应用
于对应的控制器。
• InitBinder 是一 允许构建 POJO 参数的方法，允许在构造控制器参数的时候，
加入一定的自定义控制。
• ExceptionHandler ，通过它可以注册一个控制器异常，使用当控制器发生注册异常
就会跳转到该方法上。
• ModelAttribute ，是一种针对于数据模型的注解，它先于控制器方法运行，当标注
方法返回对象时 它会保存到数据模型中。*/
@ControllerAdvice(basePackageClasses = {ShowController.class})
public class CommonControllerAdvice {

	//定义HTTP对应参数处理规则
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//针对日期类型的格式化，其中CustomDateEditor是客户自定义编辑器
         //它的boolean参数表示是否允许为空
		binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
 
     //处理数据模型，如果返回对象，则该对象会保存在
	@ModelAttribute
	public void populateModel(Model model) {
		model.addAttribute("projectName", "JavaSpringMvcXmlDemo");
	}

	//异常处理，使得被拦截的控制器方法发生异常时，都能用相同的视图响应
	@ExceptionHandler(Exception.class)
	public String exception() {
		return "error";
	}

}
