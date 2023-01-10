package com.codegym.repository.payment;

import com.codegym.model.payment.OrderAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IOrderAlbumRepository extends JpaRepository<OrderAlbum, Integer> {
}
