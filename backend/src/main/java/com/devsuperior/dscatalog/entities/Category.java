package com.devsuperior.dscatalog.entities;
import javax.persistence.*;
import java.io.Serializable;//Converter o objeto em sequencia de bytes
//ser gravados em arquivos, passado na rede.

@Entity
@Table(name="tb_category")//definir o nome da tabela do banco
public class Category implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//informa que o ID é auto incrementável
    private Long id;
    private String name;

    public Category(){

    }

    //getters and setters
    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //método mais lento, mas com a comparação 100%
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Category category = (Category) object;
        return java.util.Objects.equals(id, category.id) && java.util.Objects.equals(name, category.name);
    }

    //Objeto padrão para verificar se um objeto é igual a outro, mais rápido
    /*public int hashCode() {
        return Objects.hash(super.hashCode(), id, name);
    }*/
}