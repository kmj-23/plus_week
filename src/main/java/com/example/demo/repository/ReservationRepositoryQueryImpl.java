package com.example.demo.repository;

import com.example.demo.entity.Reservation;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


import java.util.List;

import static com.example.demo.entity.QReservation.reservation;

@RequiredArgsConstructor
public class ReservationRepositoryQueryImpl implements ReservationRepositoryQuery {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Reservation> searchReservations(Long userId, Long itemId) {
        return jpaQueryFactory
                .selectFrom(reservation)
                .where(eqUserId(userId),
                        eqItemId(itemId))
                .fetch();
    }
    private BooleanExpression eqUserId(Long userId) {
        if(userId == null){
            return null;
        }
        return reservation.user.id.eq(userId);
    }
    private BooleanExpression eqItemId(Long itemId) {
        if(itemId == null){
            return null;
        }
        return reservation.item.id.eq(itemId);
    }
}
