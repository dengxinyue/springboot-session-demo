package com.offcn.controller;

import com.offcn.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class ThymeleafDemoController {
    /**
     * 访问http://localhost:5678/demo1
     * 将数据message填充到templates/index.html
     * @param model
     * @return
     */
    @GetMapping("/demo1")
    public String demo1(Model model){
        String message = "hello,Thymeleaf!";
        model.addAttribute("message",message);
        return "index";//跳转到模板视图
    }

    /**
     * 访问http://localhost:5678/demo2
     * 将数据填充到templates/index2.html,传递对象
     * @param model
     * @return
     */
    @GetMapping("/demo2")
    public String demo2(Model model){
        String message ="hello,Thymeleaf!";
        User user = new User();
        user.setId(1);
        user.setName("youjiuye");
        user.setAge(19);
        Map<String, Object> map = new HashMap<>();
        map.put("src","https://p.edit.6463.com/d/file/20200929/dce4845cbd069ccd13a79e67fdfb7f1d.jpg");
        map.put("url","http://www.baidu.com");
        model.addAttribute("message",message);
        model.addAttribute("user",user);
        model.addAttribute("img", map);
        return "index2";
    }

    /**
     * 遍历集合
     * @param model
     * @return
     */
    @GetMapping("demo3")
    public String demo3(Model model){
        List<User> userList = new ArrayList<>();

        User u1 = new User(1,"张三",18);
        User u2 = new User(2, "李四", 44);
        User u3 = new User(3, "王五", 55);
        User u4 = new User(4, "赵柳", 27);
        User u5 = new User(5, "神器", 66);

        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);

        model.addAttribute("userList",userList);
        return "index3";
    }

    /**
     * 字符串拼接
     * @param model
     * @return
     */
    @GetMapping("demo4")
    public String demo4(Model model){
        String name ="李美玲";
        String msg = "欢迎你来学习";

        model.addAttribute("name",name);
        model.addAttribute("msg",msg);
        return "index4";
    }

    /**
     * 判断选择语句
     * @param model
     * @return
     */
    @GetMapping("demo5")
    public String demo5(Model model){
        model.addAttribute("flag","no");
        model.addAttribute("menu","manager");
        model.addAttribute("one","manager");
        return "index5";
    }

    /**
     * 表达式内置对象的使用
     * @param model
     * @return
     */
    @GetMapping("demo6")
    public String demo6(Model model){
        //日期时间
       Date date = new Date();
       model.addAttribute("date",date);
       //小数的金额
        double price = 123.31D;
        model.addAttribute("price",price);
        //定义大文本数据
        String str = "Thymeleaf是Web和独立环境的现代服务器端Java模板引擎，能够处理HTML，XML，JavaScript，CSS甚至纯文本。\\r\\n"+
                "Thymeleaf的主要目标是提供一种优雅和高度可维护的创建模板的方式。为了实现这一点，它建立在自然模板的概念上，将其逻辑注入到模板文件中，不会影响模板被用作设计原型。这改善了设计的沟通，弥补了设计和开发团队之间的差距。\r\n" +
                "Thymeleaf也从一开始就设计了Web标准 - 特别是HTML5 - 允许您创建完全验证的模板，如果这是您需要的\r\n" ;
        model.addAttribute("str",str);
        //定义字符串
        String str2 = "JAVA-OFFCN";
        model.addAttribute("str2",str2);
        return "index6";

    }
}
