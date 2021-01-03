package lk.easyrental.spring.controller;

import lk.easyrental.spring.dto.CustomerDTO;
import lk.easyrental.spring.dto.UserRoleDTO;
import lk.easyrental.spring.service.UserRoleService;
import lk.easyrental.spring.utill.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/userRole")
@CrossOrigin
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity addUserRole(@RequestBody UserRoleDTO dto) {
        userRoleService.saveUserRole(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(params = {"type"})
    public ResponseEntity checkRoleType(@RequestParam String type) {
        UserRoleDTO userRoleDTO = userRoleService.checkUserRoleType(type);
        StandradResponse response = new StandradResponse(200, "Success", userRoleDTO.getRole_type());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
