package by.thefirstplacecoder.spring.mapper;

import by.thefirstplacecoder.spring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
public class UserMapper {
    @Autowired
    private UserDto userDto;
}