package server.model;

import shared.transferobjects.User;
import shared.transferobjects.UserList;
import java.util.List;

public class ServerLogInManager implements ServerLogIn{
    private UserList listOfAllUsers;

    public ServerLogInManager() {
        this.listOfAllUsers = new UserList();
    }

    @Override
    public boolean addUser(User user) {
        listOfAllUsers.addUser(user);
        for(int i = 0; i < listOfAllUsers.sizeOfUserList();i++){
        }
        return true;
    }

    @Override
    public boolean checkUsername(String username) {
        return !(listOfAllUsers.allUsernames().contains(username));
    }

    @Override
    public boolean checkLogInUser(User user) {
        return listOfAllUsers.containsInList(user);
    }

    @Override
    public void removeUser(User user) {
        listOfAllUsers.removeUser(user);
    }

    @Override
    public List<String> getAllUsers() {
        return listOfAllUsers.allUsernames();
    }
}
