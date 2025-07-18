
package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Constructor injection (no need for @Autowired // also double check what this means
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // POST /api/users -------------------------------------------------------------
    @PostMapping
public ResponseEntity<User> createUser(@RequestBody User user) {
    User created = userService.createUser(user);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
}

    // GET /api/users -------------------------------------------------------------
    @GetMapping
public ResponseEntity<java.util.List<User>> getAllUsers() {
    java.util.List<User> users = userService.getAllUsers();
    return new ResponseEntity<>(users, HttpStatus.OK);
}


    // GET /api/users/{id} -------------------------------------------------------------------
@GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable int id) {
    java.util.Optional<User> user = userService.getUserById(id);
    return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}


    // PUT /api/users/{id} -----------------------------------------------------------------------------------
@PutMapping("/{id}")
public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
    java.util.Optional<User> user = userService.updateUser(id, updatedUser);
    return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}


    // PATCH /api/users/{id} ---------------------------------------
@PatchMapping("/{id}")
public ResponseEntity<User> patchUser(@PathVariable int id, @RequestBody User patch) {
    java.util.Optional<User> user = userService.patchUser(id, patch.getUsername(), patch.getEmail());
    return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
}
 
    // DELETE /api/users/{id} ---------------------------------------------
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable int id) {
    boolean deleted = userService.deleteUser(id);
    return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                   : new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


}