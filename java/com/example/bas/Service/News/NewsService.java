package com.example.bas.Service.News;

import com.example.bas.Service.Model.News;
import java.util.Optional;

public interface NewsService {

    void updateNews(News news);
    Optional<News> findNewsById(int newsId);
}
