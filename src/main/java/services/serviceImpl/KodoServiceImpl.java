package services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.DBObject;

import dao.Kodo;
import domain.KodoManager;
import services.KodoService;

public class KodoServiceImpl implements KodoService {
	
	 @Autowired
	 private KodoManager kodoManager;

	@Override
	public DBObject getSearchedDetail(String searchValue) {
		return kodoManager.getSearchedDetail(searchValue);
	}

	@Override
	public List<Kodo> getKodoPagination(int limit, int offset) {
		return kodoManager.getKodoPagination(limit, offset);
	}

}
