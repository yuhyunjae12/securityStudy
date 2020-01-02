package com.my.res.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MembersVo implements UserDetails{
	
	private Long SEQ;
	private String ID;
	private String PASSWORD;
	private String AUTHORITY;
	private String NAME;
	private boolean ENABLED;
	private boolean CREDEXPI;
	
	
	public Long getSEQ() {
		return SEQ;
	}
	public void setSEQ(Long sEQ) {
		SEQ = sEQ;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getAUTHORITY() {
		return AUTHORITY;
	}
	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public boolean isENABLED() {
		return ENABLED;
	}
	public void setENABLED(boolean eNABLED) {
		ENABLED = eNABLED;
	}
	public boolean isCREDEXPI() {
		return CREDEXPI;
	}
	public void setCREDEXPI(boolean cREDEXPI) {
		CREDEXPI = cREDEXPI;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(AUTHORITY));
		return auth;
	}
	@Override
	public String getPassword() {
		return PASSWORD;
	}
	@Override
	public String getUsername() {
		return ID;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return ENABLED;
	}
	

}
