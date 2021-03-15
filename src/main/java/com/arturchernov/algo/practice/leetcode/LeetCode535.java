package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 535. Encode and Decode TinyURL
 * <p>
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class LeetCode535 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String res = codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(res);
    }

    static class Codec {
        private final String BASE = "http://tinyurl.com/";
        private final Map<Integer, String> db = new HashMap<>();

        public String encode(String from) {
            int hash = from.hashCode();
            db.put(hash, from);
            return BASE + Integer.toString(hash, 16);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String hash = shortUrl.substring(BASE.length());
            return db.get(Integer.parseInt(hash, 16));
        }
    }
}