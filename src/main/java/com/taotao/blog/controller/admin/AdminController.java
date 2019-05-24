package com.taotao.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Taotao Ma
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/posts")
    public String managePage() {
        return "admin/manage";
    }
}