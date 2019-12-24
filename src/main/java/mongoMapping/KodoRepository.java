package mongoMapping;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dao.Kodo;

@Repository
public interface KodoRepository extends MongoRepository<Kodo, String> {
	
}