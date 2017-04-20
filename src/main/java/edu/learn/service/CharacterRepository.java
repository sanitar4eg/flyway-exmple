package edu.learn.service;

import edu.learn.domain.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "characters", path = "characters")
interface CharacterRepository extends PagingAndSortingRepository<Character, Long> {

	Character findByNameAllIgnoringCase(@Param("name") String name);

	Page<Character> findByStatusContainingAllIgnoringCase(@Param("status") String status, Pageable pageable);

}
