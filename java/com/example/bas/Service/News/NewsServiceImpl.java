package com.example.bas.Service.News;

import com.example.bas.Service.Model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired

    @Qualifier("NewsRepositoryImpl")
    com.example.bas.Repository.News.NewsRepository NewsRepository;

    @Override
    public void updateNews(News news) {
        NewsRepository.updateNews(news);
    }

    @Override
    public Optional<News> findNewsById(int newsId) {
        return NewsRepository.findNewsById(newsId);
    }
}
