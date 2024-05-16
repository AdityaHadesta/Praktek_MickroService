package com.aditya.pembayaran.repository;

import com.aditya.pembayaran.entity.Pembayaran;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long> {
    public List<Pembayaran> findAll();
}