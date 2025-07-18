package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.dao.BlogPostDao;
import com.example.model.BlogPost;

@Repository
public class BlogPostDaoImpl implements BlogPostDao {
    private final List<BlogPost> blogPosts = new ArrayList<>();
    private int nextId = 1;

    @Override 
    public List<BlogPost> getAllBlogPosts() {
        return new ArrayList<>(blogPosts);
    }

    @Override
    public Optional<BlogPost> getBlogPostById(int id) { // !!!!!!! please figure out how this one works
        return blogPosts.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setId(nextId++);
        blogPosts.add(blogPost);
        return blogPost;
    }

    @Override
    public Optional<BlogPost> updateBlogPost(int id, BlogPost updatedBlogPost) {
        return getBlogPostById(id).map(existing -> {
            existing.setTitle(updatedBlogPost.getTitle());
            existing.setContent(updatedBlogPost.getContent());
            return existing;
        });
    }

    @Override
    public Optional<BlogPost> patchBlogPost(int id, String title, String content) {
        return getBlogPostById(id).map(existing -> {
            if (title != null) existing.setTitle(title);
            if (content != null) existing.setContent(content);
            return existing;
        });
    }

       @Override
    public boolean deleteBlogPost(int id) {
        return blogPosts.removeIf(b -> b.getId() == id);
    }

}
