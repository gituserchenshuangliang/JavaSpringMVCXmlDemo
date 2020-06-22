//package com.spring.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.multipart.support.StandardServletMultipartResolver;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
//
//import javax.servlet.MultipartConfigElement;
//import javax.servlet.annotation.MultipartConfig;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.Arrays;
//
///**
// * @description:Java配置文件上传
// * @author: Cherry
// * @time: 2020/6/13 12:19
// */
//@MultipartConfig(location = "E:/ServiceDemo",maxFileSize = 50000000,maxRequestSize = 1000000000,fileSizeThreshold = 0)
//public class ConfigDemo {
//
//    @Bean
//    public RequestMappingHandlerAdapter initJsonConverter() {
//        //创建 RequestMappingHandlerAdapter 适配器
//        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
//        //HTTP JSON 转换器
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
//        //http 类型支持为 JSON 类型
//        MediaType[] mediaType = {MediaType.APPLICATION_JSON};
//        //加入转换器的支持类型
//        jsonConverter.setSupportedMediaTypes(Arrays.asList(mediaType));
//        jsonConverter.setDefaultCharset(Charset.defaultCharset());
//        //往适配器加入 JSON 转换器
//        handlerAdapter.getMessageConverters().add(jsonConverter);
//        return handlerAdapter;
//    }
//
//    @Bean(name = "multipartResolver")
//    public MultipartResolver initMultipartResolver() {
//        return new StandardServletMultipartResolver();
//    }
//
//    @Bean(name = "multipartResolver")
//    public MultipartResolver initCommonsMultipartResolver() {
//        //文件上传路径
//        String filepath = "E:/ServiceDemo";
//        //5MB
//        Long singleMax = (long) (5 * Math.pow(2, 20));
//        //10MB
//        Long totalMax = (long) (10 * Math.pow(2, 20));
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSizePerFile(singleMax);
//        multipartResolver.setMaxUploadSize(totalMax);
//        try {
//            multipartResolver.setUploadTempDir(new FileSystemResource(filepath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return multipartResolver;
//    }
//}
