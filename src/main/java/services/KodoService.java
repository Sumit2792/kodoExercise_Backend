package services;

import java.util.List;

import com.mongodb.DBObject;

import dao.Kodo;

public interface KodoService {
		
	DBObject getSearchedDetail(String searchValue);

	List<Kodo> getKodoPagination(int limit, int offset);

}
