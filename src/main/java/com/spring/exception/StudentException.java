package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//新增Spring MVC的异常映射，code代表异常映射码，而reason则代表异常原因
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "找不到学生信息异常！！")
public class StudentException extends RuntimeException  {
}