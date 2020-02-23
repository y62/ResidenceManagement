package com.example.bas.Repository.News;

import com.example.bas.Service.Model.News;
import java.util.Optional;

public interface NewsRepository {

    int updateNews(News news);
    Optional<News> findNewsById(int newsId);
}
