package com.spring.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @description:首页控制
 * SpringMVC 相当于是个消息传
 * 递和处理框架
 * @author: Cherry
 * @time: 2020/6/9 8:45
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
