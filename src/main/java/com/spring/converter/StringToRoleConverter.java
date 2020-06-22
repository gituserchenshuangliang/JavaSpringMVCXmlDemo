package com.spring.converter;

import com.spring.entity.Role;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * @description:HTTP消息转换器
 * HttpMessageConverter SpringMVC 用处较广的设计，
 * 主要的作用在于 Java HTTP 之间的消息转换。
 * 对于 细节上的转换，是以 Spring Core 项目提供的 Converter,GenericConverter ，
 * 以及 Spring context 包的 Formatter 进行转换
 * @author: Cherry
 * @time: 2020/6/13 16:33
 */
public class StringToRoleConverter implements Converter<String, Role> {
    /**
     * id - name - note 字符转换为Role对象
     * @param source 目标字符串
     * @return
     */
    @Override
    public Role convert(String source) {
        //空串
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        //不包含指定字符
        if (source.indexOf("-") == -1) {
            return null;
        }
        String[] arr = source.split("-");
        //字符串长度不对
        if (arr.length != 3) {
            return null;
        }
        Role role = new Role();
        role.setId(Integer.parseInt(arr[0]));
        role.setName(arr[1]);
        role.setNote(arr[2]);
        return role;
    }
}
