package com.example.bas.Repository.News;

import com.example.bas.Service.Model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("NewsRepositoryImpl")
public class NewsRepositoryImpl implements NewsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int updateNews(News news) {
        return jdbcTemplate.update(
                "update news set news_headline = ?, news_text = ? where news_id = ?",
                news.getNewsHeadline(), news.getNewsText(), news.getNewsId());
    }

    @Override
    public Optional<News> findNewsById(int newsId) {
        return jdbcTemplate.queryForObject(
                "select * from news where news_id = ?",
                new Object[]{newsId},
                (resultSet, rowNum) ->
                        Optional.of(new News(
                                resultSet.getInt("news_id"),
                                resultSet.getString("news_headline"),
                                resultSet.getString("news_text")
                        ))
        );
    }
}
