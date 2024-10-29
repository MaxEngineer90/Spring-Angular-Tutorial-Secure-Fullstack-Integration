package eu.backend.controller.user;

import eu.backend.dto.UserDTO;
import eu.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    @PreAuthorize("hasRole('BACKEND_USER')")
    public ResponseEntity<UserDTO> getUser(@AuthenticationPrincipal UserDTO user) {
        return ResponseEntity.ok(userService.getUserWithAddress(user));
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('BACKEND_ADMIN')")
    public ResponseEntity<UserDTO> getAdmin(@AuthenticationPrincipal UserDTO user) {
        return ResponseEntity.ok(userService.getUserWithAddress(user));
    }
}