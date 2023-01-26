package practice;

import java.util.Arrays;
import java.util.PriorityQueue;

// 973 - K Closest Points to Origin

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);

		for (int[] point : points) {
			pq.offer(point);

			if (pq.size() > k) {
				pq.poll();
			}
		}

		int[][] result = new int[k][2];

		while (k > 0) {
			k--;
			result[k] = pq.poll();
		}
		return result;
	}

	public int[][] kClosest1(int[][] points, int k) {
		Arrays.sort(points, (a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
		return Arrays.copyOfRange(points, 0, k);
	}

	public int[][] kClosest2(int[][] points, int k) {
		int n = points.length;
		int l = 0;
		int r = n - 1;

		while (l < r) {
			int pIndex = partition(points, l, r);

			if (pIndex == k) { // not k-1
				break;
			}
			if (pIndex < k) {
				l = pIndex + 1;
			} else {
				r = pIndex - 1;
			}
		}

		return Arrays.copyOfRange(points, 0, k);
	}

	private int partition(int[][] points, int left, int right) {
		int pivot = points[right][0] * points[right][0] + points[right][1] * points[right][1];
		int pIndex = left;

		for (int i = left; i < right; i++) {
			if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pivot) {
				swap(points, pIndex, i);
				pIndex++;
			}
		}

		swap(points, pIndex, right);

		return pIndex;
	}

	private void swap(int[][] points, int left, int right) {
		int[] temp = points[left];
		points[left] = points[right];
		points[right] = temp;
	}
}
