package es.urjc.code.repository;

import es.urjc.code.models.CountPronvinciasDTO;
import es.urjc.code.models.Provincia;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {

    @Aggregation(pipeline = {"{ '$group': { '_id' : '$CA'}}"})
    List<CountPronvinciasDTO> findCountProvincias();

}