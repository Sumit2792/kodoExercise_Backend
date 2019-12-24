package domain;

import java.util.List;

import com.mongodb.DBObject;

import dao.Kodo;

public interface KodoManager {
	
	List<Kodo> getAllKodoDetails();
	
	DBObject getSearchedDetail(String searchValue);

	List<Kodo> getKodoPagination(int limit, int offset);

}
