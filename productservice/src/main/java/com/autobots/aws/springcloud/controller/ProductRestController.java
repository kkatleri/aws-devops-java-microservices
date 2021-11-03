package com.autobots.aws.springcloud.controller;

import com.autobots.aws.springcloud.dto.Coupon;
import com.autobots.aws.springcloud.model.Product;
import com.autobots.aws.springcloud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRepository productRepository;

    @Value("${coupon.serviceUrl}")
    private String couponServiceUrl;

    @RequestMapping(value="/products", method= RequestMethod.POST)
    public Product create(@RequestBody  Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceUrl+product.getCouponCode(), Coupon.class);
        System.out.println("Coupon details received - " + coupon);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return productRepository.save(product);
    }

    @RequestMapping(value="/products/{name}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String name){
        return productRepository.findByName(name);
    }
}
