package com.formation.spring.util;

public class Config {
	String appVersion;
	String orgName;
	String maxDbLines;
	
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getMaxDbLines() {
		return maxDbLines;
	}
	public void setMaxDbLines(String maxDbLines) {
		this.maxDbLines = maxDbLines;
	}
	
}
