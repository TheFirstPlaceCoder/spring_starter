package by.thefirstplacecoder.integration.service;

import by.thefirstplacecoder.annotation.IT;
import by.thefirstplacecoder.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;

    @Test
    void test() {

    }
}
