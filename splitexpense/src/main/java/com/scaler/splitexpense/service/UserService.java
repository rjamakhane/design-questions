package com.scaler.splitexpense.service;

import com.scaler.splitexpense.models.User;
import com.scaler.splitexpense.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User createUser(User request){
        String passwpord = passwordEncoder.encode(request.getPassword());
        User user = request.toBuilder().password(passwpord).build();
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(List<Long> memberIds) {
        return userRepository.findAllById(memberIds);
    }
}

