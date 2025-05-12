package sudark2.Sudark.fightTheLandlord;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static sudark2.Sudark.fightTheLandlord.FightTheLandlord.getPlugin;

public class EventListener implements Listener {

    @EventHandler
    public void EventListener(PlayerChatEvent e) {
        if (e.getMessage().equalsIgnoreCase("ddz")) {
            new BukkitRunnable() {
                int time = 0;
                int lordWon = 0;
                double Balance = 0;

                @Override
                public void run() {
                    Random r = new Random();
                    for (int o = 0; o < 100; o++) {

                        List<String> cards = new ArrayList<>(Cards.cards);
                        List<String> farmer1 = new ArrayList<>();
                        List<String> farmer2 = new ArrayList<>();
                        List<String> lord = new ArrayList<>();

                        while (cards.size() > 3) {
                            farmer1.add(cards.remove(r.nextInt(cards.size())));
                            farmer2.add(cards.remove(r.nextInt(cards.size())));
                            lord.add(cards.remove(r.nextInt(cards.size())));
                        }
                        lord.addAll(cards);

                        double famer1Score = Calculate.calculate(farmer1);
                        double famer2Score = Calculate.calculate(farmer2);
                        double lordScore = Calculate.calculate(lord);

                        if (lordScore > famer1Score && lordScore > famer2Score) {
                            lordWon++;
                        }

                        Balance += (famer1Score + famer2Score) / 2.0 - lordScore;
                        System.out.printf(" %d | 轮   地主：%.2f | 农民1：%.2f | 农民2：%.2f%n",
                                time * 100 + o, lordScore, famer1Score, famer2Score);

                    }

                    time++;

                    if (time == 1000) {
                        cancel();
                        e.getPlayer().sendMessage("游戏结束，地主获胜次数为：" + lordWon + "，平均收益为：" + Balance);
                    }

                }
            }.runTaskTimer(getPlugin(), 0, 1);

        }
    }
}
