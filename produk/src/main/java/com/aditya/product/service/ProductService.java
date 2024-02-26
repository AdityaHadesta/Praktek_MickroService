/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aditya.product.service;

import com.aditya.product.entity.Product;
import java.util.List;
import org.springframework.stereotype.Service;
import com.aditya.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lenovo
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAll(){
        return productRepository.findAll();
    }
    
    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    } 
    
    public void insert(Product product){
        productRepository.save(product);
    }
    
    @Transactional
    public void update(Long ProductId, String kode, String nama, String satuan, double harga ){
        Product product = productRepository.findById(ProductId)
                .orElseThrow(
                    () -> new IllegalStateException("Produk Tidak Ada")
                );
            if(kode != null && kode.length()>0 
                    && !Objects.equals(product.getKode(), kode)){
            product.setKode(kode);
        }    
            if(nama != null && nama.length()>0 
                    && !Objects.equals(product.getNama(), nama)){
            product.setNama(nama);
        }
            if(satuan != null && satuan.length()>0 
                    && !Objects.equals(product.getSatuan(), satuan)){
            product.setSatuan(satuan);
        }
            if(harga != 0
                    && !Objects.equals(product.getHarga(), harga)){
            product.setHarga(harga);
        }
    }
    
    public void delete(Long productId){
        productRepository.deleteById(productId);
    }
}

