package bbm.owner;

import bbm.manager.Manager;

import java.util.Scanner;

public class OwnerController  {
    protected void addUser(Manager manager, Owner owner){
        owner.addUser(manager);
    }

}
