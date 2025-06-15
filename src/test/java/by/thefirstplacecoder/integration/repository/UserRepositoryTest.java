package by.thefirstplacecoder.integration.repository;

import by.thefirstplacecoder.annotation.IT;
import by.thefirstplacecoder.spring.database.entity.Role;
import by.thefirstplacecoder.spring.database.repository.UserRepository;
import by.thefirstplacecoder.spring.dto.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var page = userRepository.findAllBy(pageable);
        page.forEach(u -> System.out.println(u.getId()));
        while (page.hasNext()) {
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(u -> System.out.println(u.getId()));
            System.out.println(page.getTotalPages());
        }
    }

    @Test
    void checkOrderingAndLimitForList() {
        var users = userRepository.findFirstCountByCompanyId(1, "id", 3);
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void checkOrderingAndLimit() {
        var users = userRepository.findFirstByCompanyId(1);
        assertTrue(users.isPresent());
        users.ifPresent(u -> assertEquals("Kate", u.getFirstname()));
    }

    @Test
    void checkAutoMapping() {
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
    }

    @Test
    void checkMapping() {
        var users = userRepository.findAllByCompanyId(1, PersonalInfo.class);
        assertThat(users).hasSize(2);
    }

    @Test
    void updateRoleTest() {
        var enityt1 = userRepository.findById(1L);
        assertEquals(Role.ADMIN, enityt1.get().getRole());

        var result = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, result);

        var enityt2 = userRepository.findById(1L);
        assertEquals(Role.USER, enityt2.get().getRole());
    }

    @Test
    void findAllByFirstnameAndLastName() {
        var user = userRepository.findAllByNameAndLastname("a", "a");
        assertFalse(user.isEmpty());
        assertThat(user).hasSize(3);
    }
}