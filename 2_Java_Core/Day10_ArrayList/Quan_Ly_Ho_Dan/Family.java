package Day10_ArrayList.Quan_Ly_Ho_Dan;

import java.util.ArrayList;

public class Family {
    private String houseNumber;
    private int numberOfMembers;
    private ArrayList<Person> members;
    
    // Setter
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }
    public void setMembers(ArrayList<Person> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "houseNumber: " + houseNumber +
            ", numberOfMembers: " + numberOfMembers +
            ", members: " + members;
    }
}