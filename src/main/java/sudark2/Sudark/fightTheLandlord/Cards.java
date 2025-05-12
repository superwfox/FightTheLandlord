package sudark2.Sudark.fightTheLandlord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cards {

    static ArrayList cards = new ArrayList<>(54);
    static String[] faces = {
            "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K", "1", "2"
    };

    public static void initialise() {
        for (String f : faces) {
            for (int i = 0; i < 4; i++) {
                cards.add(new String(f));
            }
        }
        cards.add(new String("W"));  // 大王
        cards.add(new String("w"));  // 小王
    }

}
