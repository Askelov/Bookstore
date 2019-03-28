package org.olivebh.bookstore.service.impl;

import org.olivebh.bookstore.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    public Long checkValidNumber(String num){
        try {
            return Long.parseLong(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("Expected whole number as argument");
        }
    }
}
