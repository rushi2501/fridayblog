package com.example.dao;

import java.util.List;
import java.util.Optional;

import com.example.model.BlogPost;

public interface BlogPostDao {
    List<BlogPost> getAllBlogPosts();
    Optional<BlogPost> getBlogPostById(int id);
    BlogPost createBlogPost(BlogPost blogPost);
    Optional<BlogPost> updateBlogPost(int id, BlogPost updatedBlogPost);
    Optional<BlogPost> patchBlogPost(int id, String title, String content);
    boolean deleteBlogPost(int id);
}
