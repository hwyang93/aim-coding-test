package com.aim.project.domain.user.repository;

import com.aim.project.domain.user.dto.UserDto;
import com.aim.project.domain.user.dto.UserLoginDto;
import com.aim.project.domain.user.entity.QUser;
import com.aim.project.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;
    QUser qUser = QUser.user;

    public User signUp(User user) {
        em.persist(user);
        return user;
    }

    public User login(UserLoginDto user) {
        final JPAQuery<User> query = new JPAQuery<>(em);
        return query.from(qUser).where(qUser.username.eq(user.getUsername())).fetchOne();
    }
}
