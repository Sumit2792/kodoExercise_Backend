package controller;

import java.util.List;

import com.mongodb.DBObject;

import dao.Kodo;

public interface KodoController {
	
	List<Kodo> getAllKodoDetails();
	
	DBObject getSearchedDetail(String searchValue);

	List<Kodo> getKodoPagination(int limit, int offset);

}
