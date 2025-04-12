package com.vaibhav.joblisting.Controller;

import com.vaibhav.joblisting.Repository.PostRepository;
import com.vaibhav.joblisting.Repository.SearchRepository;
import com.vaibhav.joblisting.model.Post;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
public class PostController {

    @Autowired
    SearchRepository srepo;

    @Autowired
    PostRepository repo;

    @Hidden
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping("/posts")
    private List<Post> getAllPosts(){
        return repo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        System.out.println(post);
        return repo.save(post);
    }

    @CrossOrigin(origins = "http://localhost:5173/")
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }
}
