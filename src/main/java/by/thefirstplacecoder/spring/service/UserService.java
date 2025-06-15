package by.thefirstplacecoder.spring.service;

import by.thefirstplacecoder.spring.database.repository.UserRepository;
import by.thefirstplacecoder.spring.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
}