package com.wecare.contoller;

public class CommandFactory {
    public Command createCommand(String commandStr) 
    {
    	Command command = null;
    	
        if (commandStr.equals("login")) {
    		command = new LoginCommand();
    	}
        
    	if (commandStr.equals("signup")) {
    		command = new RegisterCommand();
    	}
    	
    	if(commandStr.equals("displayUsers")) {
    		command = new DisplayUsersCommand();  
    	}
    	
    	if(commandStr.equals("deleteUser")) {
    		command = new DeleteByIDCommand(); 
    	}
    	
    	if(commandStr.equals("searchUser")) {
    		command = new SearchUserCommand();
    	}
 
		if(commandStr.equals("displayFormsByUsertype")) {
			command = new DisplayUpdateFormsByUsertype();
		}
        
		if(commandStr.equals("updateUsers")) {
			command = new UpdateUserInfoCommand();
		}
		
		if(commandStr.equals("processGuestUsers")) {
			command = new DisplayGuestList();
		}
		
    	return command;
    }    
}

