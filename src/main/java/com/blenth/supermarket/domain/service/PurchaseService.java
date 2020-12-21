package com.blenth.supermarket.domain.service;

import com.blenth.supermarket.domain.Purchase;
import com.blenth.supermarket.persitence.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    CompraRepository compraRepository;

    public List<Purchase> getAll() {
        return compraRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return compraRepository.save(purchase);
    }


}
