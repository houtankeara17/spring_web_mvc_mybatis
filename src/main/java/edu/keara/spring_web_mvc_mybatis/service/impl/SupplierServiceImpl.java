package edu.keara.spring_web_mvc_mybatis.service.impl;

import edu.keara.spring_web_mvc_mybatis.model.Supplier;
import edu.keara.spring_web_mvc_mybatis.repository.SupplierRepository;
import edu.keara.spring_web_mvc_mybatis.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    // -----------------------
    // Find by id
    // -----------------------
    @Override
    public Supplier findSupplierById(Integer id) {
        Supplier existSupplier = supplierRepository.findById(id);
        if(existSupplier == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Supplier with id %d does not exist", id));
        }
        return existSupplier;
    }

    // -----------------------
    // Find all or Get all
    // -----------------------
    @Override
    public List<Supplier> findAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers;
    }

    // -----------------------
    // Create new supplier
    // -----------------------
    @Override
    @Transactional
    public void createSupplier(Supplier supplier) {

        supplierRepository.insert(supplier);
    }

    // -----------------------
    // Update supplier by id
    // -----------------------
    @Override
    @Transactional
    public void updateSupplier(Integer id, Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(id);
        if(existingSupplier == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Supplier with id %d does not exist", id));
        }
        existingSupplier.setId(id);
        supplierRepository.update(supplier);
    }

    // -----------------------
    // Update status supplier
    // -----------------------
    @Override
    @Transactional
    public void updateStatus(Integer id, Boolean status) {

        Supplier existingSupplier = supplierRepository.findById(id);
        if (existingSupplier == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Supplier with id %d does not exist", id));
        }
        existingSupplier.setStatus(status);
        supplierRepository.update(existingSupplier);
    }

    // -----------------------
    // Delete supplier by id
    // -----------------------
    @Override
    @Transactional
    public void deleteSupplier(Integer id) {
        Supplier existingSupplier = supplierRepository.findById(id);
        if(existingSupplier == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Supplier with id %d does not exist", id));
        }
        supplierRepository.deleteById(id);
    }
}
