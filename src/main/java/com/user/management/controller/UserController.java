package com.user.management.controller;

import com.user.management.model.Response;
import com.user.management.model.User;
import com.user.management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/signup")
    public String getSignup()
    {
        return "signup";
    }

    @PostMapping("/accounts/register")
    public ResponseEntity<?> addUser(@RequestBody User user)
    {   log.error(user.toString());
        StringBuilder stringBuilder=new StringBuilder("success");
        List<User> list = userRepository.findByEMAIL(user.getEmail());
        Response response = new Response();

        if(list.size()!=0)
        {
            stringBuilder.append("message. Oops!  There is already a user registered with the email provided.");
            response.setResponseMessage(String.valueOf(stringBuilder));
            response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
            log.error("fail : " + response.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
        else
        {
            userRepository.save(user);
            stringBuilder.append("message. User has been successfully registered.");
            response.setResponseMessage(String.valueOf(stringBuilder));
            response.setResponseCode(HttpStatus.OK.toString());
            log.error("success : " + response.toString());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }

    }

    @GetMapping("/getUser")
    public ResponseEntity<?> addUser(@RequestParam("user_email") String user_email)
    {
        StringBuilder stringBuilder=new StringBuilder("success");
        List<User> list = userRepository.findByEMAIL(user_email);
        Response response = new Response();
        if(list.size()!=0)
        {
            response.setUser(list.get(0));
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }
        else
        {
            response.setResponseMessage(String.valueOf(stringBuilder.append("message. Oops!  No User Present.")));
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        }


    }

}
