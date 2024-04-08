package Hotel;

public class generic<T,S> {
	private T a1,a2;
	private S a3,a4;
	
	public generic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public generic(T a1, S a3) {
		super();
		this.a1 = a1;
		this.a3 = a3;
	}

	public generic(T a1, T a2, S a3) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
	}
	
	public T getA1() {
		return a1;
	}

	public void setA1(T a1) {
		this.a1 = a1;
	}

	public T getA2() {
		return a2;
	}

	public void setA2(T a2) {
		this.a2 = a2;
	}

	public S getA3() {
		return a3;
	}

	public void setA3(S a3) {
		this.a3 = a3;
	}

	public S getA4() {
		return a4;
	}

	public void setA4(S a4) {
		this.a4 = a4;
	}
	
}
