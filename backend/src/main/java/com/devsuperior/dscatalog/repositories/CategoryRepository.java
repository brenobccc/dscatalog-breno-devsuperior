package com.devsuperior.dscatalog.repositories;

import com.devsuperior.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//camada de acesso a dados
@Repository//registra como um componente injetável
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
