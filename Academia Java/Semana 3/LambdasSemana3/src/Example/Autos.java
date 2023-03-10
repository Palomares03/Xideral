package Example;

public class Autos {
	
	private int id;
	private String marca;
	private String modelo;
	private double precio;
	
	public Autos(int id, String marca, String modelo, double precio) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "AUTO [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + "]";
	}

	
}