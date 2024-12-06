package org.pgm.shopserver.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.pgm.shopserver.model.User;
import org.pgm.shopserver.service.AuthenticationService;
import org.pgm.shopserver.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("sign-up")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        log.info("Authentication Controller user111111111111111111111111111111111+="+user);
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<Object> signIn(@RequestBody User user){
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
