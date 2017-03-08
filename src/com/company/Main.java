package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Territory territory = new Territory();

//        Territory country = territory.clone();

        Random rn = new Random();
        Territory country = territory.clone();
        for (int c = 0; c < 2; c++) {
            Territory region = territory.clone();
            for (int m = 0; m < 2; m++) {
                Territory oblast = territory.clone();
                for (int t = 0; t < 2; t++) {
                    Territory town = territory.clone();
                    for (int k = 0; k < 3; k++) {
                        Territory rayon = territory.clone();
                        for (int j = 0; j < 3; j++) {
                            Territory kvartal = territory.clone();
                            for (int i = 0; i < 10; i++) {
                                Territory house = territory.clone();
                                house.setCountPpl((rn.nextInt(150) + 100));
                                //System.out.println(house.getCountPpl());
                                kvartal.add(house);
                            }
                            kvartal.setSquare((rn.nextInt(30000) + 10000));
                            kvartal.setCountPpl(kvartal.sumPpl());
                            //System.out.println("В квартале" + j + " " + kvartal.getChildTer().size() + " домов");
                            rayon.add(kvartal);
                        }
                        rayon.setSquare(rayon.sumSq());
                        rayon.setCountPpl(rayon.sumPpl());
                        //System.out.println("В районе" + k + " " +  rayon.getChildTer().size() + " квартала");
                        town.add(rayon);
                    }
                    town.setSquare(town.sumSq());
                    town.setCountPpl(town.sumPpl());
                    town.setBudget((rn.nextInt(10000000) + 50000000));
                    //System.out.println("В городе" + t + " " +  town.getChildTer().size() + " районов");
                    oblast.add(town);
                }
                oblast.setSquare(oblast.sumSq());
                oblast.setCountPpl(oblast.sumPpl());
                oblast.setBudget(oblast.sumBudget());
                //System.out.println("В области" + m + " " +  oblast.getChildTer().size() + " городов");
                region.add(oblast);
            }
            region.setSquare(region.sumSq());
            region.setCountPpl(region.sumPpl());
            region.setBudget(region.sumBudget());
            country.add(region);
        }

        System.out.println("Количество людей " + country.sumPpl());
        System.out.println("Общая площадь " + country.sumSq());
        System.out.println("Общий бюджет " + country.sumBudget());
        //System.out.println(country.getChildTer());
    }
}
