package entities;

public class Bill {

	public char gender;
	public int beer;
	public int barbecue;
	public int softDrink;

	public double cover(){
		if(feeding() > 30.00) {
			return 0.00;
		} else {
			return 4.00;
		}
	}

	public double feeding(){
		double feeding = ((this.beer * 5.00) + (this.barbecue *7.00) + (this.softDrink * 3.00));
		return feeding;
	}

	public double ticket(){
		if (gender == 'M' || gender == 'm'){
			return 10.00;
		}else {
			 return 8.00;
		}
	}

	public double total(){
		double total = (this.cover() + this.feeding() + this.ticket());
		return total;
	}
}
