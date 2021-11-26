package com.devsuperior.dscatalog.resources;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscatalog.dto.CategoryDTO;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController//efetua um préprocessamento ao processar, e será disponibilizada como recurso
@RequestMapping(value = "/categories")//rota do rest
public class CategoryResource{

    //criando dependencia
    @Autowired
    private CategoryService service;

    //criando END POINTS
    //encapsula uma resposta http
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        /*List<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Books"));
        list.add(new Category(2L, "Electronics"));*/
        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);//resposta 200
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
            CategoryDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);//resposta 200
    }

    //inserindo uma nova categoria no banco
    @PostMapping
    public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
        dto = service.insert(dto);

        //inserir o objeto respondendo o cabeçalho da resposta
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}