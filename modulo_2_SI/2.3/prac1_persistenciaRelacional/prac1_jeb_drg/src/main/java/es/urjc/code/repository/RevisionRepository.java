package es.urjc.code.repository;

import es.urjc.code.models.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {

}
