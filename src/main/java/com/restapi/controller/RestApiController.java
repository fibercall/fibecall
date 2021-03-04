package com.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.OdishaPops;
import com.restapi.services.RestApiService;

@RestController
public class RestApiController {
	private static final Logger logger = Logger.getLogger(RestApiController.class);
	
	@Autowired
	RestApiService service;

	@RequestMapping(value = "/getOdishaPops", method = RequestMethod.GET )
	@ResponseBody
	public List<OdishaPops> getOdishaPops() {

		List<OdishaPops> popsList = new ArrayList<>();
		try {
			logger.info(" getOdishaPops() :: START");

			popsList = service.getOdishaPops();
			logger.info("getOdishaPops() :: END");
		} catch (Exception e) {
			logger.error("The Exception is RestController :: getOdishaPops" + e);
			e.printStackTrace();
		} finally {

		}
		return popsList;

	}
}
