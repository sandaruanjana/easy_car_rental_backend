package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.UserDTO;
import lk.easyrental.spring.service.UserService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")

@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDTO dto) {
        userService.saveUser(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"id"})
    public ResponseEntity searchUserName(@RequestParam String id) {
        boolean byUsernameEquals = userService.findByUsernameEquals(id);
        StandradResponse response = new StandradResponse(200, "Success", byUsernameEquals);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{login}")
    public ResponseEntity userLogin(@RequestBody UserDTO dto) {
        UserDTO login = userService.login(dto);
        login.getUser_role_id();
        StandradResponse response = new StandradResponse(200, "Success", login.getUser_id());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"role"})
    public ResponseEntity checkUserRole(@RequestParam String role) {
        UserDTO userDTO = userService.checkUserRole(role);
        StandradResponse response = new StandradResponse(200, "Success", userDTO.getUser_role_id());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"user"})
    public ResponseEntity searchUser(@RequestParam String user) {
        UserDTO userDTO = userService.searchUser(user);
        StandradResponse response = new StandradResponse(200, "Success", userDTO);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }



}
