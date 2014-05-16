package com.mijiang.algo.search;

public class KeyPoorHash {
	
	private int a;
	private int b;
	private int c;
	
	public KeyPoorHash(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyPoorHash other = (KeyPoorHash) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

}
