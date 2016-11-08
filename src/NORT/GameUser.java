package NORT;

/**
 * Created by Supakarn on 11/9/2016.
 */
public interface GameUser{
    public String getUsername();
    public String getPassword();
    public void createUser(String username,String password);
    public boolean userLogin(String username,String password);
}
