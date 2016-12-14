package com.xinyang.dao;

import com.xinyang.pojo.Comment;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by car on 2016/12/14.
 */
public class CommentDaoTest {
    @Test
    public void addComment() throws Exception {
        Comment comment = new Comment(1, "第一条评论", "内容", 1);
        CommentDao commentDao = new CommentDao();
        commentDao.addComment(comment);
    }

}