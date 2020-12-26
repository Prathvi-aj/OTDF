package models;

public class Response extends Post{
	//--------------INSTANCE-VARIABLES-------------

	private Integer responseId;
	private	Question question;
	//private Post post;
	
	//--------------SETTERS-GETTERS----------------

	public void setResponseId(Integer responseId){
		this.responseId = responseId;
	}

	public Integer getResponseId(){
		return responseId;
	}

	//---------------------------------------------

	public void setQuestion(Question question){
		this.question = question;
	}

	public Question getQuestion(){
		return question;
	}
	
	//---------------------------------------------
	/*
	public void setPost(Post post){
		this.post = post;
	}

	public Post getPost(){
		return post;
	}*/
}