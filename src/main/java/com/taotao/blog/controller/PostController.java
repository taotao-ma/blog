package com.taotao.blog.controller;

import com.taotao.blog.dao.Data;
import com.taotao.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PostController {

    private Data postRepository = new Data();

    @RequestMapping(value = "/", method = GET)
    public String index(Model model) {
        model.addAttribute("posts", postRepository.posts);
        return "index";
    }

    @RequestMapping(value = "/posts/create", method = GET)
    public String createPage() {
        return "create";
    }

    @RequestMapping(value = "/posts/", method = POST)
    public String createPost(@RequestParam("title") String title,
                             @RequestParam("content") String content) {
        Post post = new Post(title, content);
        postRepository.posts.add(post);

        return String.format("redirect:/posts/%d", post.getId());
    }

    @RequestMapping(value = "/posts/{id}", method = GET)
    public String post(@PathVariable("id") int id, Model model) {
        Post post = postRepository.posts.get(id);
        model.addAttribute("post", post);

        return "item";
    }
}
