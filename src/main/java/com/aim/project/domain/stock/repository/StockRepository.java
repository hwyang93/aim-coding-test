package com.aim.project.domain.stock.repository;

import com.aim.project.domain.stock.dto.UserLoginDto;
import com.aim.project.domain.stock.entity.Stock;
import com.aim.project.domain.user.entity.QUser;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StockRepository {
    @PersistenceContext
    private EntityManager em;
    QUser qUser = QUser.user;

    public Stock signUp(Stock user) {
        em.persist(user);
        return user;
    }

    public Stock login(UserLoginDto user) {
        final JPAQuery<Stock> query = new JPAQuery<>(em);
        return query.from(qUser).where(qUser.username.eq(user.getUsername())).fetchOne();
    }
}
