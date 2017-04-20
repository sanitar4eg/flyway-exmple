package edu.learn.service;

import edu.learn.domain.Gadget;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gadget", path = "gadgets")
public interface GadgetRepository extends PagingAndSortingRepository<Gadget, Long> {

	Gadget findByNameIgnoringCase(@Param("name") String name);

	Page<Gadget> findByTypeContainingAllIgnoringCase(@Param("type") String type, Pageable pageable);

}
