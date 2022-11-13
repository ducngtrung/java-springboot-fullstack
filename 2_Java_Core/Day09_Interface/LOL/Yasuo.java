package Day09_Interface.LOL;

public class Yasuo implements CanSurf {
    String hair;
    String weapon;

    // Getter
    public String getHair() {
        return hair;
    }
    public String getWeapon() {
        return weapon;
    }

    // Setter
    public void setHair(String hair) {
        this.hair = hair;
    }
    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void display() {
        System.out.print("Yasuo with " + this.hair + " hair, using " + weapon);
    }

    @Override
    public void surf() {
        System.out.println(", can surf");        
    }
}
