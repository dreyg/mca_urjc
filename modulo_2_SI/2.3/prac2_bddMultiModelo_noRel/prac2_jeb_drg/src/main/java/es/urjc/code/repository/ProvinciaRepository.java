package es.urjc.code.repository;



import es.urjc.code.models.CountPronvinciasDTO;
import es.urjc.code.models.Provincia;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProvinciaRepository extends MongoRepository<Provincia, String> {


    /*
    * db.provincia.aggregate( [
      {
        $group: {
           _id: CA,
           numProvincias: { $sum: 1 }
        }
      }
    ] )
    --------------------
    @Aggregation(pipeline = {"$group: {_id: $CA}, numProvincias: { $sum:1}"})
    *
    */
    @Aggregation(pipeline = {"{ '$group': { '_id' : '$CA'}}"})
    List<CountPronvinciasDTO> findCountProvincias();

}
