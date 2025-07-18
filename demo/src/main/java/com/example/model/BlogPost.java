package com.example.model;
import java.util.List;

public class BlogPost {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private List<String> tags;

    public BlogPost(int id, String title, String content, int authorId, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
