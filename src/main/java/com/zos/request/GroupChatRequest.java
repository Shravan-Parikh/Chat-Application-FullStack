package com.zos.request;

import java.util.List;

public class GroupChatRequest {
	
	private List<Integer> userIds;
	
	public GroupChatRequest() {
		// TODO Auto-generated constructor stub
	}

	public GroupChatRequest(List<Integer> userIds) {
		super();
		this.userIds = userIds;
	}

	public List<Integer> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
	
}
