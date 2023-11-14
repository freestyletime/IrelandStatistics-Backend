package ie.chrischen.irelandstatistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IrelandStatisticsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrelandStatisticsBackendApplication.class, args);
	}

}
