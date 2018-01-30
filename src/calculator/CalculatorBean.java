package calculator;

public class CalculatorBean {
	private String argument;
	private String operator="=";
	private String wynik="";
	private String color;
	private String color_tla;
	
	private boolean start=true;

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getWynik() {
		return wynik;
	}

	public void setWynik(String wynik) {
		this.wynik = wynik;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor_tla() {
		return color_tla;
	}

	public void setColor_tla(String color_tla) {
		this.color_tla = color_tla;
	}

	
}
