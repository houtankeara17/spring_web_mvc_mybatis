package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.model.Supplier;
import edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository;
import edu.keara.spring_web_mvc_mybatis.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public void createSupplier(Supplier supplier) {

        supplierRepository.insert(supplier);
    }

    @Override
    public void updateSupplier(Integer id, Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(id);
        if(existingSupplier == null){
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
        existingSupplier.setId(id);
        supplierRepository.update(supplier);
    }

    @Override
    public void updateStatus(Integer id, Boolean status) {

        Supplier existingSupplier = supplierRepository.findById(id);
        if (existingSupplier == null) {
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
        existingSupplier.setStatus(status);
        supplierRepository.update(existingSupplier);
    }

    @Override
    public void deleteSupplier(Integer id) {
        Supplier existingSupplier = supplierRepository.findById(id);
        if(existingSupplier == null){
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier findSupplierById(Integer id) {
        Supplier existSupplier = supplierRepository.findById(id);
        if(existSupplier == null){
            throw new RuntimeException("Supplier with id " + id + " does not exist");
        }
        return existSupplier;
    }

    @Override
    public List<Supplier> findAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers;
    }
}
