package com.wecare.serviceInterface;

import org.bson.Document;

import com.wecare.model.user.Users;

public interface UserServiceInterface {
	public Document insert(Users u);
}
