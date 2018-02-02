package Output;

import java.io.*;

public class Serializ {
    public static void main(String[] args) {

        GameCharcter one = new GameCharcter(50, "Elf", new String[]{"лук", "меч"});
        GameCharcter two = new GameCharcter(70, "Ork", new String[] {"голые руки", "большой топор"});
        GameCharcter three = new GameCharcter(120, "DarkElfian", new String[]{"заклинания", "невидимость"});

        one.power = one.getPower() + 150;


        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:/BD/game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:/BD/game.ser"));
            GameCharcter oneRes = (GameCharcter) is.readObject();
            GameCharcter twoRes = (GameCharcter) is.readObject();
            GameCharcter threeRes = (GameCharcter) is.readObject();

            System.out.println("Type of first: " + oneRes.getType() + " Power is :" + oneRes.getPower());
            System.out.println("Type of second: " + twoRes.getType() + " Power is :" + twoRes.getPower());
            System.out.println("Type of thrid: " + threeRes.getType() + " Power is :" + threeRes.getPower());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class GameCharcter implements Serializable {

    int power;
    String type;
    String[] weapons;

    public GameCharcter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weapon = "";
        for (int i = 0; i <weapons.length ; i++) {
            weapon += weapons[i] + " ";
        }

        return weapon;
    }
}
