package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    // create change(set) get
    @Autowired
    ShippingRepository shippingRepository;

    public void setShippingInfo (ShippingInfo ship) {

        shippingRepository.changeShippingInfo(ship.getStatus(), ship.getId());
    }

    public ShippingInfo getShippingInfo (Long id) {

        return shippingRepository.getShippingInfo(id);
    }

    public void newShipping (ShippingInfo ship) {

        shippingRepository.createShippingInfo(ship);
    }

    public void change (String status, Long id) {
        shippingRepository.changeShippingInfo(status, id);
    }

    public boolean checkShipping () {
        int count = shippingRepository.checkShippingInfo();
        boolean ret = false;
        if (count != 0) ret = true;

        return ret;
    }
}
