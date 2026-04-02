package com.example.sd20308.repository;

import com.example.sd20308.model.DrinkTmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkTmpRepo extends JpaRepository<DrinkTmp, Integer> {

    @Query(value = """
            select c.id, c.name , count(d.category_id) as 'so_luong'
            from categories c inner join drinks d on c.id = d.category_id
            GROUP by c.id, c.name
            """, nativeQuery = true)
    List<DrinkTmp> getList();
}
