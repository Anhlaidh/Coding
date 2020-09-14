package test;

import Java.Java_Final.Annotation.Test;
import Java.test.PS;
import org.openjdk.jmh.annotations.*;


/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 15:13
 */
public class PSTest {
    @Benchmark
    @Warmup(iterations = 1, time = 3)
    @Fork(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1, time = 3)
    public void testForEach() {

        PS.foreach();

    }

    @Benchmark
    @Warmup(iterations = 1, time = 3)
    @Fork(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1, time = 3)
    public void testParallel() {
        PS.parallel();
    }

    @Test
    public void test() {
        System.out.println("aaaa");
    }
}
