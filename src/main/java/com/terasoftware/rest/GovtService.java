package com.terasoftware.rest;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.terasoftware.pojo.CafStatus;
import com.terasoftware.utils.DBUtil;


@Path("/pop")
public class GovtService {

	@Path("/mo")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getNodeWisePopDataReq() {
		String popDataResponse = "";
		try{
			DBUtil dbUtil = new DBUtil();
			Connection con = dbUtil.mysqlConnection();
			popDataResponse = new Gson().toJson(this.getNodeTypePopDataDB(con));
		}catch(Exception e){
			e.printStackTrace();
		}


		return popDataResponse;
	}
	
	public List<PopBean> getNodeTypePopDataDB(Connection con){
		Statement stmt=null;
		String sql="";
		ResultSet rs=null;
		List<PopBean> popBeanList = new ArrayList<PopBean>();
		try
		{
			stmt = con.createStatement();
			sql="select fp.POP_POINT_X, fp.POP_POINT_Y, ol.OLT_DOWN_IPADDRESS, ol.OLT_DOWN_DISTRICT, ol.OLT_DOWN_MANDAL,"
					+ " ol.OLT_DOWN_SUBST_DESC, ol.OLT_DOWN_DATE, ol.OLT_DOWN_TIME, ol.OLT_DOWN_UP_DATE, ol.OLT_DOWN_UP_TIME,"
					+ "  ol.OLT_DOWN_REASON, ol.OLT_DOWN_REASON_DETAIL, ol.OLT_DOWN_TIMESTAMP,"
					+ " ol.OLT_DOWN_SUBCATEGORY, ol.OLT_DOWN_TICKET_ID from OLT_DOWN_REPORT ol left join FIBERGRID_POPS fp  on ol.OLT_DOWN_IPADDRESS= fp.POP_IPADDRESS  "
					+ "where ol.OLT_DOWN_REASON_DETAIL is not null group by ol.OLT_DOWN_REASON_DETAIL";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) 
			{
				PopBean popBean = new PopBean();
				popBean.setIpaddress(rs.getString("ol.OLT_DOWN_IPADDRESS"));
				popBean.setDowndate(rs.getString("ol.OLT_DOWN_DATE"));
				popBean.setDownreason(rs.getString("ol.OLT_DOWN_REASON"));
				popBean.setSubsategory(rs.getString("ol.OLT_DOWN_SUBCATEGORY"));
				popBean.setTicketid(rs.getString("ol.OLT_DOWN_TICKET_ID"));
				popBean.setDownreasonindetailed(rs.getString("ol.OLT_DOWN_REASON_DETAIL"));
				popBean.setLat(rs.getString("fp.POP_POINT_X"));
				popBean.setLog(rs.getString("fp.POP_POINT_Y"));
				popBean.setUpdate(rs.getString("ol.OLT_DOWN_UP_DATE"));
				popBean.setUptime(rs.getString("ol.OLT_DOWN_UP_TIME"));
				popBean.setDowntime(rs.getString("ol.OLT_DOWN_TIME"));
				popBean.setDistrict(rs.getString("ol.OLT_DOWN_DISTRICT"));
				popBean.setMandal(rs.getString("ol.OLT_DOWN_MANDAL"));
				
				
			

				popBeanList.add(popBean);
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
		return popBeanList;
	}
	
	protected class PopBean {
		private String ipaddress;
		private String district;
		private String mandal;
		private String lat;
		private String log;
		private String substation;
		private String downdate;
		private String downtime;
		private String update;
		private String uptime;
		private String downreason;
		private String downreasonindetailed;
		private Timestamp downtimestamp;
		private String subsategory;
		private String ticketid;
		
		
		
		 
		public String getIpaddress() {
			return ipaddress;
		}
		public void setIpaddress(String ipaddress) {
			this.ipaddress = ipaddress;
		}
		public String getLat() {
			return lat;
		}
		public void setLat(String lat) {
			this.lat = lat;
		}
		public String getLog() {
			return log;
		}
		public void setLog(String log) {
			this.log = log;
		}
		public String getSubstation() {
			return substation;
		}
		public void setSubstation(String substation) {
			this.substation = substation;
		}
		public String getDowndate() {
			return downdate;
		}
		public void setDowndate(String downdate) {
			this.downdate = downdate;
		}
		public String getDowntime() {
			return downtime;
		}
		public void setDowntime(String downtime) {
			this.downtime = downtime;
		}
		public String getUpdate() {
			return update;
		}
		public void setUpdate(String update) {
			this.update = update;
		}
		public String getUptime() {
			return uptime;
		}
		public void setUptime(String uptime) {
			this.uptime = uptime;
		}
		public String getDownreason() {
			return downreason;
		}
		public void setDownreason(String downreason) {
			this.downreason = downreason;
		}
		public String getDownreasonindetailed() {
			return downreasonindetailed;
		}
		public void setDownreasonindetailed(String downreasonindetailed) {
			this.downreasonindetailed = downreasonindetailed;
		}
		
		public Timestamp getDowntimestamp() {
			return downtimestamp;
		}
		public void setDowntimestamp(Timestamp downtimestamp) {
			this.downtimestamp = downtimestamp;
		}
		public String getSubsategory() {
			return subsategory;
		}
		public void setSubsategory(String subsategory) {
			this.subsategory = subsategory;
		}
		public String getTicketid() {
			return ticketid;
		}
		public void setTicketid(String ticketid) {
			this.ticketid = ticketid;
		}
		public String getDistrict() {
			return district;
		}
		public void setDistrict(String district) {
			this.district = district;
		}
		public String getMandal() {
			return mandal;
		}
		public void setMandal(String mandal) {
			this.mandal = mandal;
		}
		
		
	}
		
	}

