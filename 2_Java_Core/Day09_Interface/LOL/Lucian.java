package Day09_Interface.LOL;

public class Lucian implements CanShoot, CanSurf {
    private String hair;
    private String weapon;

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
        System.out.print("Lucian with " + this.hair + " hair, using " + weapon);
    }

    @Override
    public void surf() {
        System.out.print(", can surf");        
    }

    @Override
    public void shoot() {
        System.out.print(", can " + CanShoot.action);        
    }

    @Override
    public void checkDefault() {
        CanShoot.super.checkDefault();
        System.out.println("Override default method");
    }
}