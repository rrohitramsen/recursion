package com.program.recursion;

public class TowerOfHanoi {
	
	public void moveTower(int n, char src, char dst, char tmp){
		
		if (n>0) {
			moveTower(n-1, src, tmp, dst);
			moveSingleDisk(src, dst);
			moveTower(n-1, tmp, dst, src);
		}
	}

	private void moveSingleDisk(char src, char dst) {
		// TODO Auto-generated method stub
		
	}
}
