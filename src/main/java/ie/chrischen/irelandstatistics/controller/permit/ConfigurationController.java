package ie.chrischen.irelandstatistics.controller.permit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1/employment-permit")
public class ConfigurationController {

    private Resource getResource() {
        return new ClassPathResource("config.json");
    }

    @GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> config() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(getResource().getInputStream(), StandardCharsets.UTF_8));

            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) sb.append(line);
            return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
    }
}
