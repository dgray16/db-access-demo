package com.inventorsoft.querydsloverjpa.user.service;

import com.inventorsoft.querydsloverjpa.db.entity.QUser;
import com.inventorsoft.querydsloverjpa.db.entity.User;
import com.inventorsoft.querydsloverjpa.user.model.AggregatedUserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserWebService {

    JPAQueryFactory jpaQueryFactory;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return jpaQueryFactory.selectFrom(QUser.user).fetch();
    }

    @Transactional(readOnly = true)
    public List<AggregatedUserDto> getAllUsersWithAggregation() {
        return jpaQueryFactory
                .select(Projections.constructor(AggregatedUserDto.class, QUser.user.firstName, QUser.user.firstName.count()))
                .from(QUser.user)
                .groupBy(QUser.user.firstName)
                .fetch();
    }

}
