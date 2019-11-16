package practice.practice11;

abstract class Series {
	abstract int getNthNumber(int n);
}

class Factorial extends Series{
	@Override
	int getNthNumber(int n) {
		// TODO Auto-generated method stub
		if (n == 0)
			return 1;
		return n * getNthNumber(n - 1);
	}
}

class Fibonacci extends Series {

	@Override
	int getNthNumber(int n) {
		// TODO Auto-generated method stub
		int first = 0, second = 1;
		int result = 0;
		if (n == 0) return first;
		if (n == 1) return second;
		for (int i = 2; i < n; i++) {
			result = first + second;
			first = second;
			second = result;
		}
		return result;
	}
	
}

class Prime extends Series {

	@Override
	int getNthNumber(int n) {
		// TODO Auto-generated method stub
		int idx = 0;
		int num = 1;
		while(idx < n) {
			num++;
			if (isPrime(num)) {
				idx++;
			}
		}
		return num;
	}
	
	private boolean isPrime(int num) {
		for (int factor = 2; factor <= Math.sqrt(num); factor++) {
			if (num % factor == 0)
				return false;
		}
		return true;
	}
	
}