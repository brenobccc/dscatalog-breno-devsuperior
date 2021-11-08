package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/*
    Irá registrar essa classe como um componente
    que vai participar do sistema de injeção de
    dependencia automatizado do spring
*/
@Service
public class CategoryService {

    @Autowired//o spring trata de injetar uma dependencia válida
    private CategoryRepository repository;//dependencia

    public List<Category> findAll(){
        return repository.findAll();
    }
}
