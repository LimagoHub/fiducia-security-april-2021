package de.fiducia.security.security.models;



import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_user")
public class User  implements UserDetails {
	

	private static final long serialVersionUID = -6486214960326841088L;

	@Id	@Column(length = 50)
//	@Pattern(regexp="^[a-zA-Z0-9ÄÖÜäüö]{6,50}$",message="username braucht min. 6 Stellen, nur Buchstaben und Ziffern sind erlaubt.")
	@Email
	@NotEmpty
	private String username;

	@JsonIgnore
	//@Pattern(regexp="^((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,255})$",message="Password braucht min. 6 Stellen, muss min. einen Gross- und einen Kleinbuchstaben, sowie eine Ziffer und eines dieser Zeichen '@#$%' enthalten.")  
	//@Size(min = 6, max=255)
	//@NotEmpty(message = "Password darf nicht leer sein.")
	private String password;

	@Column(length = 50)
	@Size(min = 2, max=50)
	@NotEmpty 
	private String fullname;	
	
	
	
	
	private String rolle= "USER";
	
	private boolean enabled = true;
	
	private LocalDateTime lastUpdate;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + rolle));
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
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
		return enabled;
	}
	

	
	@PrePersist
	public void setCreateTime() {
		lastUpdate = LocalDateTime.now();
	}
	
	@PreUpdate
	public void setUpdateTime() {
		lastUpdate = LocalDateTime.now();
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(final String fullname) {
		this.fullname = fullname;
	}



	public String getRolle() {
		return rolle;
	}

	public void setRolle(final String rolle) {
		this.rolle = rolle;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	
	

}
