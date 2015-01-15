'No more loops' - Java 8 Streams benchmark
==========================================

This is a benchmark comparing the effectiveness of Java 8 Streams and
traditional, imperative loop-based code. The original article from where the
code was taken can be found [here](http://www.deadcoderising.com/java-8-no-more-loops/),
and the blog discussing the benchmark is [here](http://endoflineblog.com/benchmarking-java8-streams).

Running the benchmark
---------------------

Execute in a terminal:

    ./gradlew jmh

in the root directory of the project. The results will be in `build/reports/jmh`.
