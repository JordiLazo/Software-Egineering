package shared.transferobjects;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> listOfAllUsers;

    public UserList(){
        this.listOfAllUsers = new ArrayList<>();
    }

    public void addUser(User user){
        listOfAllUsers.add(user);
    }

    public void removeUser(User user){
        listOfAllUsers.remove(user);
    }

    public ArrayList<String> allUsernames(){
        ArrayList<String> listOfUsernames = new ArrayList<>();
        for(int i = 0; i < listOfAllUsers.size();i++){
            listOfUsernames.add(listOfAllUsers.get(i).getUsername());
        }
        return listOfUsernames;
    }

    public boolean containsInList(User user){
        for(int i = 0; i < listOfAllUsers.size(); i++){
            if(user.equals(listOfAllUsers.get(i))){
                return true;
            }
        }
        return false;
    }

    public int sizeOfUserList(){
        return listOfAllUsers.size();
    }

    public User getUser(int index){
        return listOfAllUsers.get(index);
    }
}
