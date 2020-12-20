package com.blenth.supermarket.persitence.mapper;

import com.blenth.supermarket.domain.Category;
import com.blenth.supermarket.persitence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //con esto indicamos, que la fuente que sea idCategoria, lo lleve a categoryId
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    // con esto le indicamos que tiene que hacer el mappeo inverso
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
