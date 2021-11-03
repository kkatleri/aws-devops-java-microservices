package com.autobots.aws.springcloud.couponservice.repository;

import com.autobots.aws.springcloud.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String code);
}
