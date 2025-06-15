package by.thefirstplacecoder.spring.database.repository;

import by.thefirstplacecoder.spring.database.entity.Role;
import by.thefirstplacecoder.spring.database.entity.User;
import by.thefirstplacecoder.spring.dto.IPersonalInfo;
import by.thefirstplacecoder.spring.dto.PersonalInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllBy(Pageable pageable);

    @Query("""
            select u from User u
            order by :labelToSort desc
            limit :limited
            """)
    List<User> findFirstCountByCompanyId(Integer companyId, String labelToSort, Integer limited);

    @Query("""
            select u from User u
            order by u.id desc
            limit 1
            """)
    Optional<User> findFirstByCompanyId(Integer companyId);

    @Query(value = "select firstname, lastname, birth_date from users where company_id = :companyId",
            nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);

    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

    @Query("""
            select u from User u
            where u.firstname like %:firstname% and u.lastname like %:lastname%
            """)
    List<User> findAllByNameAndLastname(String firstname, String lastname);

    @Query(value = "select * from users where username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User set role = :role where id in (:ids)")
    int updateRole(Role role, Long... ids);
}