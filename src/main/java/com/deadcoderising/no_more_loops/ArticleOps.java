package com.deadcoderising.no_more_loops;

import java.util.*;
import java.util.stream.Collectors;

public class ArticleOps {
    private final List<Article> articles;

    public ArticleOps(List<Article> articles) {
        this.articles = articles;
    }

    public Article getFirstJavaArticle_loop() {
        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                return article;
            }
        }
        return null;
    }

    public Optional<Article> getFirstJavaArticle_stream() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    public List<Article> getAllJavaArticles_loop() {
        List<Article> result = new ArrayList<>();

        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }

        return result;
    }

    public List<Article> getAllJavaArticles_stream() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    public Map<String, List<Article>> groupByAuthor_loop() {
        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> articles = new ArrayList<>();
                articles.add(article);
                result.put(article.getAuthor(), articles);
            }
        }

        return result;
    }

    public Map<String, List<Article>> groupByAuthor_stream() {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }

    public Set<String> getDistinctTags_loop() {
        Set<String> result = new HashSet<>();

        for (Article article : articles) {
            result.addAll(article.getTags());
        }

        return result;
    }

    public Set<String> getDistinctTags_stream() {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }
}
