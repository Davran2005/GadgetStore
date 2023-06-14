package peaksoft;

import lombok.Builder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Builder

public class GadgetStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(GadgetStoreApplication.class, args);
    }

}
