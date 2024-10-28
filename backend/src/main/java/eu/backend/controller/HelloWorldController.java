package eu.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldController {

    @GetMapping()
    public ResponseEntity<String> getHellloWorld() {
        return ResponseEntity.ok("Hello World");
    }
}
