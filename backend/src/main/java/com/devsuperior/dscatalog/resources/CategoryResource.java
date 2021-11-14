package com.devsuperior.dscatalog.resources;


import java.util.ArrayList;
import java.util.List;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController//efetua um préprocessamento ao processar, e será disponibilizada como recurso
@RequestMapping(value = "/categories")//rota do rest
public class CategoryResource{

    //criando dependencia
    @Autowired
    private CategoryService service;

    //criando END POINTS
    //encapsula uma resposta http
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        /*List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Books"));
        list.add(new Category(2L, "Electronics"));*/
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);//resposta 200
    }

}