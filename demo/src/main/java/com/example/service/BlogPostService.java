package com.example.service;
import java.util.List;
import java.util.Optional;

import com.example.model.BlogPost;


public interface BlogPostService {
    BlogPost createBlogPost(BlogPost blogPost);
    List<BlogPost> getAllBlogPosts();
    Optional<BlogPost> getBlogPostById(int id); 
    Optional<BlogPost> updateBlogPost(int id, BlogPost updatedBlogPost);
    Optional<BlogPost> patchBlogPost(int id, String title, String content);
    boolean deleteBlogPost(int id);
}