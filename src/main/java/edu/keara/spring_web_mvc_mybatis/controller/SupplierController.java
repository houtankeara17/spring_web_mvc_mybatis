package edu.keara.spring_web_mvc_mybatis.controller;

import edu.keara.spring_web_mvc_mybatis.model.Supplier;
import edu.keara.spring_web_mvc_mybatis.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;
    @GetMapping()
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        List<Supplier> results = supplierService.findAllSuppliers();
        return new ResponseEntity<>(results,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Integer id){
        Supplier result = supplierService.findSupplierById(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier){
        supplierService.createSupplier(supplier);
        return new ResponseEntity<>(supplier,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Integer id, @RequestBody Supplier supplier){
        supplierService.updateSupplier(id,supplier);
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
