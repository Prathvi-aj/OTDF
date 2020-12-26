package models;

import java.sql.*;

public class User{
	//--------------INSTANCE-VARIABLES-------------

	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private Date dateOfBirth;
	private Nation nation;
	private String areaOfInterest;
	private String organization;
	private String currentProfile;
	private Integer questionCount;
	private Integer responseCount;
	private Status status;
	private UserType userType;

	//--- Constructors ----------------------
	public User(){
	
	}

	public User(String email,String password){
		this.email = email;
		this.password = password;
	}

	public User(String userName,String email,String password){
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public User(Integer userId,String userName){
		this.userId = userId;
		this.userName = userName;
	}


	//---- Other Methods ---------------------
	public boolean registerUser(){
		boolean flag = false;
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "insert into users (user_name,email,password) value (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,userName);
			ps.setString(2,email);
			ps.setString(3,password);

			int res = ps.executeUpdate();

			if(res==1){
				flag = true;
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
		}

		return flag;
	}


	public boolean loginUser(){
		boolean flag = false;
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select user_id,user_name,date_of_birth,nation_id,"+
							"area_of_interest,organization,current_profile,"+
							"question_count,response_count,status_id,user_type_id "+
							"from users where email=? and password=?";

			PreparedStatement p = con.prepareStatement(query);
			p.setString(1,email);
			p.setString(2,password);
			ResultSet r = p.executeQuery();

			if(r.next()){
				userId = r.getInt(1);
				userName = r.getString(2);
				dateOfBirth = r.getDate(3);
				nation = new Nation(r.getInt(4));
				areaOfInterest = r.getString(5);
				organization = r.getString(6);
				currentProfile = r.getString(7);
				questionCount = r.getInt(8);
				responseCount = r.getInt(9);
				status = new Status(r.getInt(10));
				userType = new UserType(r.getInt(11));

				flag = true;
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
		}

		return flag;
	}



	//--------------SETTERS-GETTERS----------------
	
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}

	//---------------------------------------------

	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}

	//---------------------------------------------

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	//---------------------------------------------

	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}

	//---------------------------------------------

	public void setDateOfBirth(Date dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth(){
		return dateOfBirth;
	}

	//---------------------------------------------

	public void setNation(Nation nation){
		this.nation = nation;
	}

	public Nation getNation(){
		return nation;
	}

	//---------------------------------------------
	
	public void setAreaOfInterest(String areaOfInterest){
		this.areaOfInterest = areaOfInterest;
	}

	public String getAreaOfInterest(){
		return areaOfInterest;
	}

	//---------------------------------------------

	public void setOrganization(String organization){
		this.organization = organization;
	}

	public String getOrganization(){
		return organization;
	}

	//---------------------------------------------
	
	public void setCurrentProfile(String currentProfile){
		this.currentProfile = currentProfile;
	}

	public String getCurrentProfile(){
		return currentProfile;
	}

	//---------------------------------------------

	public void setQuestionCount(Integer questionCount){
		this.questionCount = questionCount;
	}

	public Integer getQuestionCount(){
		return questionCount;
	}

	//---------------------------------------------
	
	public void setResponseCount(Integer responseCount){
		this.responseCount = responseCount;
	}

	public Integer getResponseCount(){
		return responseCount;
	}

	//---------------------------------------------

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	public void setUserType(UserType userType){
		this.userType = userType;
	}
	public UserType getUserType(){
		return userType;
	}
}