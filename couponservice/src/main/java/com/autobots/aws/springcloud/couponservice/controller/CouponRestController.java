package com.autobots.aws.springcloud.couponservice.controller;

import com.autobots.aws.springcloud.couponservice.model.Coupon;
import com.autobots.aws.springcloud.couponservice.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CouponRestController {

    @Autowired
    CouponRepository couponRepository;

    @RequestMapping(value = "/coupons", method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepository.save(coupon);
    }

    @RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepository.findByCode(code);
    }

}

