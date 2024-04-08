package Hotel;

public class cliente {

	private generic <String, Long> dc;

	public cliente(generic<String, Long> dc) {
		super();
		this.dc = dc;
	}
	
	public cliente(String name, long dni) {
		dc = new generic<>(name, dni);
	}
	
	public String getName() {
		return dc.getA1();
	}
	
	public void setName(String name) {
		dc.setA1(name);
	}
	
	public long getDni() {
		return dc.getA3();
	}
	
	public void setDni(long dni) {
		dc.setA3(dni);
	}

	@Override
	public String toString() {
		return "[Nombre: " + getName() + ", CI: " + getDni() + "]";
	}
	
}
