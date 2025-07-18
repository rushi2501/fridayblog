
package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BlogPost;
import com.example.service.BlogPostService;

@RestController
@RequestMapping("/api/blogposts")
public class BlogPostController {

    private final BlogPostService blogPostService;

    // Constructor injection (no need for @Autowired // also double check what this means
    public BlogPostController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    // POST /api/blogposts -----------------------------create a blog post--------------------------------
    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@RequestBody BlogPost blogPost) {
        BlogPost created = blogPostService.createBlogPost(blogPost);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // GET /api/blogposts -------------------------------------------------------------get all blog posts

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostService.getAllBlogPosts();
        return new ResponseEntity<>(blogPosts, HttpStatus.OK);
    }
    // GET /api/blogposts/{id} -------------------------------------------------------------------get blog post by id
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable int id) {
        Optional<BlogPost> blogPost = blogPostService.getBlogPostById(id);
        return blogPost.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // PUT /api/blogposts/{id} -----------------------------------------------------------------------------------update blog post
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable int id, @RequestBody BlogPost updatedBlogPost) {
        Optional<BlogPost> blogPost = blogPostService.updateBlogPost(id, updatedBlogPost);
        return blogPost.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // PATCH /api/blogposts/{id} ---------------------------------------patch blog post
    @PatchMapping("/{id}")
    public ResponseEntity<BlogPost> patchBlogPost(@PathVariable int id, @RequestBody BlogPost patch) {
        Optional<BlogPost> blogPost = blogPostService.patchBlogPost(id, patch.getTitle(), patch.getContent());
        return blogPost.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // DELETE /api/blogposts/{id} ---------------------------------------------delete blog post
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable int id) {
        boolean deleted = blogPostService.deleteBlogPost(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                       : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
