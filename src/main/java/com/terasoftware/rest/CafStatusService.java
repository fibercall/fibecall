package com.terasoftware.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Joiner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.terasoftware.pojo.CafStatus;
import com.terasoftware.utils.DBUtil;

@Path("/caf")
public class CafStatusService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(@QueryParam("cafNos") String cafNosJson) {
		String cafNosStatusJson = "";
		try{
			List<String> cafNoList= new Gson().fromJson(cafNosJson, new TypeToken<List<String>>(){}.getType());
			cafNosStatusJson = new Gson().toJson(getOperationalStates(cafNoList));
		}catch(Exception e){
			e.printStackTrace();
		}


		return cafNosStatusJson;
	}

	public List<CafStatus> getOperationalStates(List<String> cafNoList){
		List<CafStatus> cafStatusList = new ArrayList<CafStatus>();
		try{
			String cafNosQuery = Joiner.on("','").join(cafNoList);
			DBUtil dbUtil = new DBUtil();
			Connection con = dbUtil.mysqlConnection();
			cafStatusList = getOntsWithOperationalStateDB(con, cafNosQuery);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cafStatusList;
	}


	public List<CafStatus> getOntsWithOperationalStateDB(Connection con, String cafNosQuery){
		Statement stmt=null;
		String sql="";
		ResultSet rs=null;
		List<CafStatus> cafStatusList = new ArrayList<CafStatus>();
		try
		{
			stmt = con.createStatement();
			sql="select FIBERGRID_ONTS.ONTS_CAFNO, FIBERGRID_ONTS.ONTS_OPERSTATE, FIBERGRID_ONTS.ONTS_LASTDNCAUSE "
					+ "  from FIBERGRID_ONTS where ONTS_FLAG='YES' and ONTS_CAFNO in ('"+cafNosQuery+"')";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				CafStatus cafStatus = new CafStatus();
				cafStatus.setCafNo(rs.getString("ONTS_CAFNO"));
				cafStatus.setStatus(rs.getString("ONTS_OPERSTATE"));
				if(cafStatus.getStatus()!=null && !cafStatus.getStatus().equalsIgnoreCase("Operational"))
					cafStatus.setStatus(rs.getString("ONTS_LASTDNCAUSE"));

				cafStatusList.add(cafStatus);
			}
		}catch(Exception e)

		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}
			catch(Exception e2) 
			{
				e2.printStackTrace();
			}
		}
		return cafStatusList;
	}


}