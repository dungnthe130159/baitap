package com.example.JwtDemo.util;

import java.util.List;

import com.example.JwtDemo.entity.Feature;
import com.example.JwtDemo.entity.Room;

public class PriceCalculator {
	public static double getPrice(Room room, List<Feature> features) {

        double price = room.getPrice();

        if (price < 0) {
            return -1;
        }

        for (Feature feature : features) {
            price += feature.getPrice();
        }

        return price;
    }
}
