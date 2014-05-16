package com.mijiang.algo.search;

import java.util.ArrayList;
import java.util.List;

import com.mijiang.algo.common.StdRandom;

public class HashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int collisionCnt = 0;
		List<Integer> buckets = new ArrayList<Integer>();
		List<KeyPoorHash> keys = new ArrayList<KeyPoorHash>();
		int tableSize = 1274;
		
		int entryCnt = 0;
		while (entryCnt < 1000){
			int a = StdRandom.uniform(100);
			int b = StdRandom.uniform(100);
			int c = StdRandom.uniform(100);
			//System.out.println(a + "," + b + "," +c);
			KeyPoorHash key = new KeyPoorHash(a, b, c);
			if (keys.contains(key))
				continue;
			else {
				keys.add(key);
				entryCnt++;
			}
			int bucket = (key.hashCode() & 0x7fffffff) % tableSize;
			System.out.println("hashCode: " + key.hashCode() + ", bucket: " + bucket);
			if (buckets.contains(bucket))
				collisionCnt++;
			else buckets.add(bucket);
		}
		
		System.out.println("Number of total collision: " + collisionCnt);
	}
	
	private static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

}
