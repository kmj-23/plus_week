package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 4. find or save 예제 개선
    @Transactional
    @Cacheable(value = "adminCache", key ="#userIds")
    public void reportUsers(List<Long> userIds) {
        for (Long userId : userIds) {
            User user = userRepository.findByIdOrElseThrow(userId);

            user.updateStatusToBlocked();

            userRepository.save(user);
        }
    }
}
