package models;

public class Nation{
	//--------------INSTANCE-VARIABLES-------------

	private Integer nationId;
	private String nation;
	
	//--------------CONSTRUCTORS----------------
	public Nation(){
	
	}

	public Nation(Integer nationId){
		this.nationId = nationId;
	}

	//--------------SETTERS-GETTERS----------------

	public void setNationId(Integer nationId){
		this.nationId = nationId;
	}
	
	public Integer getNationId(){
		return nationId;
	}

	//---------------------------------------------
	
	public void setNation(String nation){
		this.nation = nation;
	}
	
	public String getNation(){
		return nation;
	}
}