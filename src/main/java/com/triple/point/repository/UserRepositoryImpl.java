package com.triple.point.repository;

import com.triple.point.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final EntityManager em;

    public void registryUser(User user) {
        em.persist(user);
    }

    public User getUser(UUID userId) {
        return em.find(User.class, userId);
    }
}
