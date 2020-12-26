package models;

import java.sql.*;

public class Post{
	//--------------INSTANCE-VARIABLES-------------

	private Integer postId;
	private User user;
	private PostType postType;
	private String post;
	private Timestamp postDateTime;
	private Integer likeCount;
	private Integer disLikeCount;
	private Integer spamCount;
	private Status status;


	public boolean savePost(){
		boolean flag = false;
		
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "insert into posts (post,user_id,post_type_id) value (?,?,?)";
			PreparedStatement p = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			
			p.setString(1,post);
			p.setInt(2,user.getUserId());
			p.setInt(3,postType.getPostTypeId());

			int res = p.executeUpdate();
			if(res==1){				
				ResultSet r = p.getGeneratedKeys();
				if(r.next()){
					postId = r.getInt(1);
					flag = true;
				}
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

	public void setPostId(Integer postId){
		this.postId = postId;
	}
	public Integer getPostId(){
		return postId;
	}

	//---------------------------------------------

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	//---------------------------------------------

	public void setPostType(PostType postType){
		this.postType = postType;
	}

	public PostType getPostType(){
		return postType;
	}

	//---------------------------------------------

	public void setPost(String post){
		this.post = post;
	}

	public String getPost(){
		return post;
	}

	//---------------------------------------------

	public void setPostDateTime(Timestamp postDateTime){
		this.postDateTime = postDateTime;
	}

	public Timestamp getPostDateTime(){
		return postDateTime;
	}
	
	//---------------------------------------------
	
	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}

	public Integer getLikeCount(){
		return likeCount;
	}

	//---------------------------------------------

	public void setDisLikeCount(Integer disLikeCount){
		this.disLikeCount = disLikeCount;
	}

	public Integer getDisLikeCount(){
		return disLikeCount;
	}

	//---------------------------------------------
	
	public void setSpamCount(Integer spamCount){
		this.spamCount = spamCount;
	}

	public Integer getSpamCount(){
		return spamCount;
	}

	//---------------------------------------------

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}
}