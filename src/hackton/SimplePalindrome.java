package hackton;

import java.util.HashMap;
import java.util.Map;

public class SimplePalindrome {

	public static void main(String[] args) {

		String number = "11331";
		int count = 0;
		int k = 4;
		int[] array = new int[number.length()];

		for (int i = 0; i < number.length(); i++) {
			array[i] = Character.digit(number.charAt(i), 10);
		}

		if (k >= number.length()) {
			for (int i = 0; i < array.length; i++) {
				if (array[i] != 9) {
					array[i] = 9;
				}
			}

			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
			}
			return;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
			if (j >= array.length / 2) {
				if (array[i] != array[j]) {
					count++;
					map.put(i, j);

				}
			}
		}

		System.out.println("Min of changes required " + count);
		if (k < count) {
			System.out.print("-1");
		} else {

			if (k == count) {

				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (array[entry.getKey()] < array[entry.getValue()]) {
						array[entry.getKey()] = array[entry.getValue()];

					} else if (array[entry.getKey()] > array[entry.getValue()]) {
						array[entry.getValue()] = array[entry.getKey()];

					}
				}

			}

			else if (k > count) {
				int max = 0;
				int key = 0;

				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

					if (max < array[entry.getKey()])
						max = array[entry.getKey()];

					if (max < array[entry.getValue()])
						max = array[entry.getValue()];

				}
				for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
					if (array[entry.getKey()] != max) {
						array[entry.getKey()] = max;
					}
					if (array[entry.getValue()] != max) {
						array[entry.getValue()] = max;
					}
				}

				System.out.println("Key " + key + "Value " + max);

			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}

}
