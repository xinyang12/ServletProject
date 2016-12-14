package com.xinyang.dao;

import com.xinyang.controller.SearchArtServlet;
import com.xinyang.pojo.Article;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by car on 2016/12/14.
 */
public class ArticleDaoTest {
    @Test
    public void modifyArticle() throws Exception {
        Article article = new Article(8, "测试文章类", "测试");
        ArticleDao articleDao = new ArticleDao();
        articleDao.modifyArticle(article);
    }

    @Test
    public void getArticleById() throws Exception {
        int id = 1;
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.getArticleById(id);

        System.out.println(article.getId());
        System.out.println(article.getTitle());
        System.out.println(article.getContent());
    }

    @Test
    public void addArticle() throws Exception {
        String title = "测试文章标题";
        String content = "测试文章内容";

        ArticleDao articleDao = new ArticleDao();
        articleDao.addArticle(title, content);
    }

    @Test
    public void deleteArticle() throws Exception {

    }

    @Test
    public void getAllArticle() throws Exception {
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.getAllArticle();
//        System.out.println(list.toString());
        for (Article tmp : list) {
            System.out.println(tmp.getId());
            System.out.println(tmp.getTitle());
            System.out.println(tmp.getContent());

            System.out.println();
        }
    }

    @Test
    public void searchArticle() throws Exception {
        String title = "标题";
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.searchArticle(title);

        for (Article tmp : list) {
            System.out.println(tmp.getId());
            System.out.println(tmp.getTitle());
            System.out.println(tmp.getContent());

            System.out.println();
        }
    }

}