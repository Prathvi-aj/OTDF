package models;

public class ActionType{
	//--------------INSTANCE-VARIABLES-------------

	private Integer actionTypeId;
	private String actionType;

	//--------------SETTERS-GETTERS----------------

	public void setActionTypeId(Integer actionTypeId){
		this.actionTypeId = actionTypeId;
	}
	public Integer getActionTypeId(){
		return actionTypeId;
	}

	//---------------------------------------------

	public void setActionType(String actionType){
		this.actionType = actionType;
	}
	public String getActionType(){
		return actionType;
	}
}