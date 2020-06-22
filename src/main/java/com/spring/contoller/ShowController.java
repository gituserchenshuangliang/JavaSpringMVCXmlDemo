package com.spring.contoller;

import com.spring.entity.Role;
import com.spring.entity.Student;
import com.spring.exception.StudentException;
import com.spring.service.StudentService;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:SpringMVC之参数
 * @author: Cherry
 * @time: 2020/6/12 12:37
 */
@RestController
public class ShowController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/stu")
    public Student findOne(int uuid) {
        return studentService.findOne(uuid);
    }

    @RequestMapping("/stu1")
    public Student findOne1(@RequestParam("stu_uuid") int uuid) {
        return studentService.findOne(uuid);
    }

    @RequestMapping("/class/{uuid}")
    public List<Student> findOne2(@PathVariable("uuid") int uuid) {
        return studentService.findByClassId(uuid);
    }

    /**
     * 表单提交
     * @param role
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Role addRole(Role role) {
        System.out.println(role);
        return role;
    }

    /**
     * 上传方法一
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(@RequestParam("A")Part file) {
        String msg = "Upload Successed !";

        try {
            String fileName = file.getSubmittedFileName();

            File saveFile = new File(fileName);

            file.write("E:/ServiceDemo/"+saveFile);
        } catch (IOException e) {
            msg = "Upload Failed !";
            e.printStackTrace();

        }
        return msg;
    }

    /**
     * 上传方法二
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String uploadFile2(@RequestParam("B") MultipartFile file) {
        String msg = "Upload Successed !";
        try {
            String fileName = file.getOriginalFilename();

            File saveFile = new File(fileName);

            file.transferTo(saveFile);
        } catch (IOException e) {
            msg = "Upload Failed !";
            e.printStackTrace();

        }
        return msg;
    }

    /**
     * id - name - note 字符串转换成Role对象
     * @param role
     * @return
     */
    @RequestMapping(value = "/showRole", method = RequestMethod.GET)
    public Role showRole(Role role) {
        return role;
    }

    /***
     * @param date 日期，在@initBinder 绑定的方法有注册格式
     * @param model 数据模型，@ModelAttribute方法会先于请求方法运行
     * @return map
     */
    @RequestMapping(value = "/advice",method = RequestMethod.POST)
    public Map<String, Object> testAdvice(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @NumberFormat(pattern = "##,###.00") double amount, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        //由于@ModelAttribute注解的通知会在控制器方法前运行，所以这样也会取到数据
        map.put("project_name", model.asMap().get("projectName"));
        map.put("date", date);
        map.put("amount", amount);
        return map;
    }

    /**
     * 在进入控制器方法前运行，先从数据库中查询角色，然后以键student保存角色对象到数据模型
     * @param id student编号
     * @return student
     */
    @ModelAttribute("student")
    public Student initStudent(@RequestParam(value="id", required = false) int id) {
        //判断id是否为空
        if (id == 0 || id < 1 ) {
            return null;
        }
        Student student = studentService.findOne(id);

        if (student == null){
            throw new StudentException();
        }

        return student;
    }

    /**
     * @ModelAttribute注解从数据模型中取出数据，
     * @param student 从数据模型中取出的学生对象
     * @return 学生对象
     */
    @RequestMapping("/session/stu")
    public Student getRoleFromModelAttribute(@ModelAttribute("student") Student student) {
        return student;
    }

    //当前控制器发生RoleException异常时，进入该方法
    @ExceptionHandler(StudentException.class)
    public String HandleRoleException(StudentException e) {
        //返回指定的error.jsp页面，避免不友好
        return "error";
    }

}
