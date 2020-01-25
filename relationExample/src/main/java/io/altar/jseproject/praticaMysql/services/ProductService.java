package io.altar.jseproject.praticaMysql.services;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.praticaMysql.models.Product;
import io.altar.jseproject.praticaMysql.repositories.ProductRepository;

@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

}
