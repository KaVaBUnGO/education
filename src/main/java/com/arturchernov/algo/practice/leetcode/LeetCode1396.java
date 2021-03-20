package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1396. Design Underground System
 * <p>
 * Implement the UndergroundSystem class:
 * <p>
 * void checkIn(int id, string stationName, int t)
 * A customer with a card id equal to id, gets in the station stationName at time t.
 * A customer can only be checked into one place at a time.
 * void checkOut(int id, string stationName, int t)
 * A customer with a card id equal to id, gets out from the station stationName at time t.
 * double getAverageTime(string startStation, string endStation)
 * Returns the average time to travel between the startStation and the endStation.
 * The average time is computed from all the previous traveling from startStation to endStation that happened directly.
 * Call to getAverageTime is always valid.
 * You can assume all calls to checkIn and checkOut methods are consistent. If a customer gets in at time t1
 * at some station, they get out at time t2 with t2 > t1. All events happen in chronological order.
 */
public class LeetCode1396 {

    public static void main(String[] args) {

        /*UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge"));       // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000
        undergroundSystem.checkIn(10, "Leyton", 24);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));          // return 12.00000*/

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30);
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667
    }

    static class UndergroundSystem {

        private final Map<Integer, AverageTime> average = new HashMap<>();
        private final Map<Integer, Pair> current = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            current.put(id, new Pair(t, stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair last = current.get(id);
            int hash = last.station.concat(stationName).hashCode();
            AverageTime existed = average.get(hash);
            if (existed != null) {
                existed.add(t - last.t);
            } else {
                average.put(hash, AverageTime.of(t - last.t));
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            int hash = startStation.concat(endStation).hashCode();
            return average.get(hash).getResult();
        }

        static class Pair {
            private final int t;
            private final String station;

            public Pair(int t, String station) {
                this.t = t;
                this.station = station;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair visitor = (Pair) o;
                return t == visitor.t && Objects.equals(station, visitor.station);
            }

            @Override
            public int hashCode() {
                return Objects.hash(t, station);
            }
        }

        static class AverageTime {
            private int sum = 0;
            private int count = 0;

            private AverageTime() {
            }

            static AverageTime of(int sum) {
                AverageTime averageTime = new AverageTime();
                averageTime.sum += sum;
                averageTime.count = 1;
                return averageTime;
            }

            public void add(int sum) {
                this.sum += sum;
                ++this.count;
            }

            public double getResult() {
                return (double) sum / count;
            }

        }
    }
}