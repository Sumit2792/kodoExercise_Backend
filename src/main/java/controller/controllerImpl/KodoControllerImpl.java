package controller.controllerImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import controller.KodoController;
import dao.Kodo;

import mongoMapping.KodoRepository;
import services.KodoService;

@RestController
@RequestMapping(value = "/kodo")
public class KodoControllerImpl implements KodoController {
	
	 @Autowired
	 private KodoService kodoService;
	 
	 @Autowired
	 private KodoRepository kodoRepository;
	 
	 public KodoControllerImpl(KodoRepository kodoRepository, KodoService kodoService) {
		 logger.info("Getting all kodo ddsdetails");
			this.kodoRepository = kodoRepository;
			this.kodoService = kodoService;
		}
	 
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	@GetMapping("/all")
	public List<Kodo> getAllKodoDetails() {
		logger.info("Getting all kodo details");
		List<Kodo> kodoDetails = this.kodoRepository.findAll();
		
		return kodoDetails;
	}

	@Override
	@RequestMapping(value = "/getSearchedDetail/{searchValue}", method = RequestMethod.GET)
	public DBObject getSearchedDetail(@PathVariable("searchValue") String searchValue) {
		return this.kodoService.getSearchedDetail(searchValue);
	}

	@Override
	@RequestMapping(value = "/getKodoPagination/{limit}/{offset}", method = RequestMethod.GET)
	public List<Kodo> getKodoPagination(@PathVariable("limit") int limit, @PathVariable("offset") int offset) {
		return this.kodoService.getKodoPagination(limit, offset);
	}

}
