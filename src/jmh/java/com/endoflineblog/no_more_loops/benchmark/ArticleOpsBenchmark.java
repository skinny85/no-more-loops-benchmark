package com.endoflineblog.no_more_loops.benchmark;

import com.deadcoderising.no_more_loops.Article;
import com.deadcoderising.no_more_loops.ArticleOps;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class ArticleOpsBenchmark {
    @State(Scope.Benchmark)
    public static class BenchmarkState {
        ArticleOps articlesOps = new ArticleOps(BenchmarkData.generateArticles(100_000));

        public BenchmarkState() {
            System.out.println("--- BenchmarkState created ---");
        }
    }

    public ArticleOpsBenchmark() {
        System.out.println("===== Benchmark created =====");
    }

    @Benchmark
    public Article getFirstJavaArticle_loop_benchmark(BenchmarkState state) {
     return state.articlesOps.getFirstJavaArticle_loop();
    }

    @Benchmark
    public Optional<Article> getFirstJavaArticle_stream_benchmark(BenchmarkState state) {
        return state.articlesOps.getFirstJavaArticle_stream();
    }

    @Benchmark
    public List<Article> getAllJavaArticles_loop_benchmark(BenchmarkState state) {
        return state.articlesOps.getAllJavaArticles_loop();
    }

    @Benchmark
    public List<Article> getAllJavaArticles_stream_benchmark(BenchmarkState state) {
        return state.articlesOps.getAllJavaArticles_stream();
    }

    @Benchmark
    public Map<String, List<Article>> groupByAuthor_loop_benchmark(BenchmarkState state) {
        return state.articlesOps.groupByAuthor_loop();
    }

    @Benchmark
    public Map<String, List<Article>> groupByAuthor_stream_benchmark(BenchmarkState state) {
        return state.articlesOps.groupByAuthor_stream();
    }

    @Benchmark
    public Set<String> getDistinctTags_loop_benchmark(BenchmarkState state) {
        return state.articlesOps.getDistinctTags_loop();
    }

    @Benchmark
    public Set<String> getDistinctTags_stream_benchmark(BenchmarkState state) {
        return state.articlesOps.getDistinctTags_stream();
    }
}
