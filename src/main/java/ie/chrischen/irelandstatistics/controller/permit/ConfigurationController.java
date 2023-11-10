package ie.chrischen.irelandstatistics.controller.permit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/api/v1/employment-permit")
public class ConfigurationController {

    private Resource getResource() {
        return new ClassPathResource("config.json");
    }

    @GetMapping(value = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> config() {
        try {
            String config = new String(Files.readAllBytes(getResource().getFile().toPath()));
            return new ResponseEntity<>(config, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
    }
}
