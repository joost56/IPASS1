package nl.hu.IPASS.security;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class MyUser implements Principal {
    private static List<MyUser> allMyUsers = new ArrayList<>();
    private String gebruikersnaam;
    private String wachtwoord;
    private String rol;

    public MyUser(String naam, String ww) {
        gebruikersnaam = naam;
        wachtwoord = ww;
        rol = "user";
        if (!allMyUsers.contains(this)) allMyUsers.add(this);
    }

        public void setAdmin(){
            rol = "admin";
        }

    @Override
    public String getName() {
        return gebruikersnaam;
    }


    public String getRol() {
        return rol;
    }
    public static MyUser getUserByName(String gnaam){
        return allMyUsers.stream()
                .filter(e->e.gebruikersnaam.equals(gnaam))
                .findFirst()
                .orElse(null);
    }
    public static String validateLogin(String gname, String ww){
        MyUser found = getUserByName(gname);
        if (found != null) return ww.equals(found.wachtwoord) ? found.getRol(): null;
        return null;
    }
}
