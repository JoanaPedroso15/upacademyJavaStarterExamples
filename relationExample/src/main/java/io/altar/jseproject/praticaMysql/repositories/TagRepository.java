package io.altar.jseproject.praticaMysql.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.jseproject.praticaMysql.models.Tag;

@ApplicationScoped
public class TagRepository extends EntityRepository<Tag> {

	@Override
	protected Class<Tag> getEntityClass() {
		return Tag.class;
	}
}