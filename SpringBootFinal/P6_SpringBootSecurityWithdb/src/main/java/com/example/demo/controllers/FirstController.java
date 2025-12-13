package com.example.demo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.LoginInfo;
import com.example.demo.entities.User;
import com.example.demo.entities.UserInfoResponse;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.UserDetailsImple;

@RestController
public class FirstController {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    UserRepository urepo;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/public")
    public String publicroute() {
        return "For all";
    }

    @GetMapping("/admin")
    public String adminroute() {
        return "For admin";
    }

    @GetMapping("/user")
    public String userroute() {
        return "For user";
    }

    // SESSION BASED LOGIN (NO JWT)
    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody LoginInfo linfo, HttpServletRequest request) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        linfo.getUsername(),
                        linfo.getPassword()
                )
        );

        // store authentication in SecurityContext
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // create session explicitly if not exists
        request.getSession(true);

        UserDetailsImple userDetails = (UserDetailsImple) authentication.getPrincipal();

        // Debug logs
        System.out.println("Logged in user: " + userDetails.getUsername());
        System.out.println("Authorities: " + userDetails.getAuthorities());
        System.out.println("Enabled: " + userDetails.isEnabled());

        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        return ResponseEntity.ok(new UserInfoResponse(userDetails.getUsername(), role));
    }


    @PostMapping("/register")
    public boolean register(@RequestBody User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        try {
            urepo.save(u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
