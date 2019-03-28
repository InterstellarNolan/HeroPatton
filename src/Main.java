import component.Battle;
import ui.HeroUI;
import hero.Character;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        HeroUI heroUI=new HeroUI();

        Character character=new Character("player","warrior");
        Battle battle=new Battle(character);
        while (true){
            try {
                char i = (char) System.in.read();
                switch(i){
                    case '0':
                        battle.attack();
                        break;
                    case '1':
                        ArrayList<Integer> arr1=new ArrayList<Integer>();
                        arr1.add(0);
                        battle.skill(arr1);
                        break;
                    case '2':
                        ArrayList<Integer> arr2=new ArrayList<Integer>();
                        arr2.add(1);
                        battle.skill(arr2);
                        break;
                    case '3':
                        ArrayList<Integer> arr=new ArrayList<Integer>();
                        arr.add(0);
                        arr.add(1);
                        battle.skill(arr);
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            String s="怪物"+String.valueOf(battle.getMonster().getHealthPoint())+"  "+"人物"+String.valueOf(battle.getCharacter().getHealthPoint());
            System.out.println(s);
            if (battle.isEnd()){
                if(battle.isWin()){
                    System.out.println("你赢了");
                    break;
                }else{
                    System.out.println("你输了");
                    break;
                }
            }
        }


    }


}
