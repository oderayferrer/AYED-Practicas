package tp2.ejercicio9;

public class Datos {

	int suma;
	int dif;
	
	public Datos(int suma, int dif) {
		this.suma = suma;
		this.dif = dif;
		}
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma = suma;
	}
	public int getDif() {
		return dif;
	}
	public void setDif(int dif) {
		this.dif = dif;
	}
	@Override
	public String toString() {
		return "Datos [suma=" + suma + ", dif=" + dif + "]";
	}
		
		
	}

