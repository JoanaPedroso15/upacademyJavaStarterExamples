package io.altar.jseproject.praticaMysql.services;

import javax.enterprise.context.RequestScoped;

import io.altar.jseproject.praticaMysql.models.Tag;
import io.altar.jseproject.praticaMysql.repositories.TagRepository;

@RequestScoped
public class TagService extends EntityService<TagRepository, Tag> {

}
