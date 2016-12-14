package com.xinyang.pojo;

/**
 * Created by car on 2016/12/14.
 */
public class Comment {
    private int id;
    private String title;
    private String content;
    private int articleId;

    public Comment() {
    }

    public Comment(int id, String title, String content, int articleId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.articleId = articleId;
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

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
