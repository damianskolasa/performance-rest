package com.example.performance.rest.domain;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.UUID;

@BenchmarkMode(Mode.Throughput)
public class ThroughputTest {

    @State(Scope.Thread)
    public static class Context {
        Balancer balancer;

        @Setup
        public void init() {
            balancer = new Balancer(new GuavaCacheUserRepository(), new ListBalancingStrategy());
        }
    }

    @Benchmark
    public String route(Context context) {
        return context.balancer.routeUser(UUID.randomUUID().toString());
    }

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(ThroughputTest.class.getSimpleName())
                .warmupIterations(10)
                .forks(1)
                .threads(10)
                .shouldFailOnError(true).shouldDoGC(true).build();
        new Runner(options).run();
    }

}
