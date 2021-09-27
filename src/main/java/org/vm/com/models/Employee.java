package org.vm.com.models;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable {


	private static final long serialVersionUID = -8429887678517367077L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	private Integer empId;
	
	private long mobile;
	private String emailId;
	
	private String designation;
	
	private Integer reportee;

	
	
	
	
	

}
