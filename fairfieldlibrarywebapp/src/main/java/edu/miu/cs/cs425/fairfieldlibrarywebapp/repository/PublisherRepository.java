package edu.miu.cs.cs425.fairfieldlibrarywebapp.repository;

import edu.miu.cs.cs425.fairfieldlibrarywebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
}
