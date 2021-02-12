package es.urjc.code.repository;

import es.urjc.code.models.Aeropuerto;
import es.urjc.code.models.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

}
