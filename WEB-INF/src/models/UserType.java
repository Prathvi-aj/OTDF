package models;

public class UserType{
	//--------------INSTANCE-VARIABLES-------------

	private Integer userTypeId;
	private String userType;

	//--------------CONSTRUCTORS----------------
	public UserType(){
		
	}

	public UserType(Integer userTypeId){
		this.userTypeId = userTypeId;
	}

	//--------------SETTERS-GETTERS----------------

	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	public Integer getUserTypeId(){
		return userTypeId;
	}

	//---------------------------------------------

	public void setUserType(String userType){
		this.userType = userType;
	}
	public String getUserType(){
		return userType;
	}
}