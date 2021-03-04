package com.restapi.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.dao.RestApiDAO;
import com.restapi.model.OdishaPops;
@Service
public class RestApiService {
	@Autowired
	RestApiDAO dao;
	
	private static final Logger logger = Logger.getLogger(RestApiService.class);


	public List<OdishaPops> getOdishaPops() {
		List<OdishaPops> popsList = new ArrayList<>();

		try{
			
			popsList = dao.getOdishaPops();
			logger.info("In service"+popsList);
		}catch (Exception e) {
			logger.error("The Exception is RestService :: getOdishaPops" + e);
			e.printStackTrace();
		}
		return popsList;
	}

}
