package edu.keara.spring_web_mvc_mybatis.repository;

import edu.keara.spring_web_mvc_mybatis.model.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupplierRepository {
    @Insert("""
    INSERT INTO suppliers(company, since, status) 
    VALUES (#{s.company}, #{s.since}, #{s.status})
    """)
    void insert(@Param("s") Supplier supplier);

    @Select("SELECT * FROM suppliers WHERE id = #{id} ")
    Supplier findById(@Param("id") Integer id);

    @Update("""
    UPDATE suppliers
    SET company = #{s.company},
        since = #{s.since},
        status = #{s.status}
    WHERE id = #{s.id};
    """)
    void update(@Param("s") Supplier supplier);

    @Delete("DELETE FROM suppliers WHERE id=#{id}")
    void deleteById(@Param("id") Integer id);

    @Select("SELECT * FROM suppliers ORDER BY id DESC")
    List<Supplier> findAll();
}
