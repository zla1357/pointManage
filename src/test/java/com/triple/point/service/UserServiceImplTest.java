package com.triple.point.service;

import com.triple.point.domain.User;
import com.triple.point.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserServiceImplTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 사용자_저장() throws Exception {
        // given
        User user = User.CreateUser();

        // when
        UUID saveId = userService.registryUser(user);
        User saveUser = userRepository.getUser(saveId);

        // then
        Assertions.assertThat(user).isEqualTo(saveUser);
    }

}