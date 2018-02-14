package co.elastic.apm.reporter;

import co.elastic.apm.report.serialize.JacksonPayloadSerializer;
import co.elastic.apm.report.serialize.PayloadSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class HttpJacksonReporterBenchmark extends AbstractHttpReporterBenchmark {

    /**
     * Convenience benchmark run method
     * <p>
     * For more accurate results, execute <code>mvn clean package</code> and run the benchmark via
     * <code>java -jar apm-agent-benchmarks/target/benchmarks.jar -prof gc</code>
     */
    public static void main(String[] args) throws RunnerException {
        new Runner(new OptionsBuilder()
            .include(HttpJacksonReporterBenchmark.class.getSimpleName())
            .addProfiler(GCProfiler.class)
            .build())
            .run();
    }

    @Override
    protected PayloadSerializer getPayloadSerializer() {
        return new JacksonPayloadSerializer(new ObjectMapper());
    }
}
