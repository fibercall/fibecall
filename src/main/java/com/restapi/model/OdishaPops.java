package com.restapi.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="odisha_pops")
public class OdishaPops implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="POP_SRNO")
	private BigInteger popSrno;
	
	@Column(name="POP_IPADDRESS")
	private String popIpaddress;
	
	@Column(name="POP_DISTRICT")
	private String popDistrict;
	
	@Column(name="POP_MANDAL")
	private String popMandal;
	
	@Column(name="POP_SUBSTN_DESC")
	private String popSubstnDesc;
	
	@Column(name="POP_NODETYPE")
	private String popNodetype;
	
	@Column(name="POP_GPONOLT")
	private String popGponolt;
	
	@Column(name="POP_UNIQID")
	private String popUniqid;
	
	@Column(name="POP_KML")
	private String popKml;
	
	@Column(name="POP_LAT")
	private Double popLat;
	
	@Column(name="POP_LON")
	private Double popLon;
	
	@Column(name="POP_APSFL_ID")
	private BigInteger popApsflid;
	
	@Column(name="POP_TYPE")
	private String popType;
	
	@Column(name="POP_ADMIN")
	private String popAdmin;
	
	@Column(name="POP_STATUS")
	private String popStatus;
	
	@Column(name="POP_SWVERSION")
	private String popSwversion;
	
	@Column(name="POP_HWVERSION")
	private String popHwversion;
	
	@Column(name="POP_MANAGED_DOMAIN")
	private String popManagedDomain;
	
	@Column(name="POP_SUBSTN_TYPE")
	private String popSubstnType;
	
	@Column(name="POP_LINK_STATUS")
	private String popLinkStatus;
	
	@Column(name="POP_CODE")
	private String popCode;
	
	@Column(name="POP_NEWIPADS")
	private String popNewipads;
	
	@Column(name="POP_REMOVED")
	private String popRemoved;
	
	@Column(name="POP_ZONE")
	private String popZone;
	
	@Column(name="POP_ZONE_ADDEDBY")
	private String popZoneAddedby;
	
	@Column(name="POP_OLTDOWNTIME")
	private String popOltdowntime;
	
	@Column(name="POP_HIDEOLT")
	private String popHideolt;
	
	@Column(name="POP_PHYSICAL_PRESENCE")
	private String popPhysicalPresence;
	
	@Column(name="POP_MAP_KEY")
	private String popMapKey;
	
	@Column(name="POP_PREV_STATUS")
	private String popPrevStatus;
	
	@Column(name="POP_CONNECTED_ONTS")
	private Integer popConnectedOnts;
	
	@Column(name="POP_FLAG_CONNECTED")
	private String popFlagConnected;
	
	@Column(name="POP_FLAG_RL_CROSSING")
	private String popFlagRlCrossing;
	
	@Column(name="POP_FLAG_OLT_AVAILABILITY")
	private String popFlagOltAvailability;
	
	@Column(name="POP_FLAG_CABLE_STATUS")
	private String popFlagCableStatus;
	
	@Column(name="POP_DOWNTIME_IN_MS")
	private BigInteger popDowntimeInMS;
	
	@Column(name="POP_OLT_SHIFT")
	private String popOltShift;
	
	@Column(name="POP_NAME")
	private String popName;
	
	@Column(name="POP_REGION")
	private String popRegion;
	

}
