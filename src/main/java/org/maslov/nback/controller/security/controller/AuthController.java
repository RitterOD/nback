package org.maslov.nback.controller.security.controller;


import org.maslov.nback.controller.security.model.ErrorResponse;
import org.maslov.nback.controller.security.model.LoginRequest;
import org.maslov.nback.controller.security.model.LoginResponse;
import org.maslov.nback.controller.security.model.SecurityUser;
import org.maslov.nback.controller.security.service.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.maslov.nback.controller.rest.v1.RestApiNamesV1.*;

@Controller
@RequestMapping(API_V1_AUTH)
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @ResponseBody
    @RequestMapping(value = LOGIN, method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginRequest loginReq)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getLogin(), loginReq.getPassword()));
            String login = authentication.getName();
            // TODO FIX this staff cast etc
            UserDetails userDetails = userDetailsService.loadUserByUsername(login);
            String token = jwtUtil.createToken((SecurityUser) userDetails);
            LoginResponse loginRes = new LoginResponse(login,token);

            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping(SECRETS)
    public ResponseEntity<String> list() {
        return ResponseEntity.ok(jwtUtil.getSecretKeys());
    }

}
