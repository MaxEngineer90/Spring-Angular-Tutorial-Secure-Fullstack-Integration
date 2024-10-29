package eu.backend.controller.nonce;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/nonce", produces = MediaType.APPLICATION_JSON_VALUE)
public class NonceController {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Map<String, String>> getNonce(HttpServletRequest request) {
        String nonce = (String) request.getAttribute("cspNonce");
        return new ResponseEntity<>(Collections.singletonMap("nonce", nonce), HttpStatus.OK);
    }
}
