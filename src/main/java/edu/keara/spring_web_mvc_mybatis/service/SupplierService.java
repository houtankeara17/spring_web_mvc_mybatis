package edu.keara.spring_web_mvc_mybatis.service;

import edu.keara.spring_web_mvc_mybatis.model.Supplier;

import java.util.List;

public interface SupplierService {
    void createSupplier(Supplier supplier);
    void updateSupplier(Integer id ,Supplier supplier);
    void updateStatus(Integer id, Boolean status );
    void deleteSupplier(Integer id);
    Supplier findSupplierById(Integer id);
    List<Supplier> findAllSuppliers();
}
