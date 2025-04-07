package intern.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intern.project.entity.Account;
import intern.project.security.JwtTokenProvider;
import intern.project.security.MyUserDetails;
import intern.project.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AccountService accService;
    @PostMapping("/login")
    public String authenticateUser( @RequestBody Account ac) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            ac.getUsername(),ac.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((MyUserDetails) authentication.getPrincipal());
        return  jwt;
    }
    @PostMapping("add_users")
    public void add_users(@RequestBody Account acc){
        accService.add_users(acc);
    }
    @PostMapping("delete_users")
    public void delete_users(@RequestParam int id){
        accService.delete_users(id);
    }
    @PostMapping("changeRoles")
    public void changeRoles(@RequestParam String roles,@RequestParam int id){
        accService.changeRoles(roles, id);
    }
}
