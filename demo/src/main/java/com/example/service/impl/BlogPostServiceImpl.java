package com.example.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.BlogPostDao;
import com.example.model.BlogPost;
import com.example.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostDao blogPostDao;

    @Autowired
    public BlogPostServiceImpl(BlogPostDao blogPostDao) {
        this.blogPostDao = blogPostDao;
    }

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostDao.createBlogPost(blogPost);
    }

    @Override
    public Optional<BlogPost> getBlogPostById(int id) {
        return blogPostDao.getBlogPostById(id);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        return blogPostDao.getAllBlogPosts();
    }

    @Override
    public Optional<BlogPost> updateBlogPost(int id, BlogPost updatedBlogPost) {
        return blogPostDao.updateBlogPost(id, updatedBlogPost);
    }

    @Override
    public Optional<BlogPost> patchBlogPost(int id, String title, String content)
    {
        return blogPostDao.patchBlogPost(id, title, content);
    }
    @Override
    public boolean deleteBlogPost(int id) {
        return blogPostDao.deleteBlogPost(id);
    }
    }
