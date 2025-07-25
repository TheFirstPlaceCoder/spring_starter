package by.thefirstplacecoder.integration;

import by.thefirstplacecoder.spring.database.repository.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestApplicationRunner {

    @SpyBean(name = "connectionPool2")
    private ConnectionPool pool1;

}
