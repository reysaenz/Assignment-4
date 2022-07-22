public class Property {
		private String name = "";
		private String city = "";
		private String owner = "";
		private double rentAmount = 0;
		private Plot plot;

		public Property() {
			this.plot = new Plot();
		}

		public Property(String name, String city, double rent, String owner) {
			this.name = name;
			this.city = city;
			this.rentAmount = rent;
			this.owner = owner;
			this.plot = new Plot();
		}
		Property(String name, String city, double rent, String owner, int X, int Y, int width, int depth) {
			this.name = name;
			this.city = city;
			this.rentAmount = rent;
			this.owner = owner;
			this.plot = new Plot(X, Y, width, depth);
		}


		public Property(Property p) {
			this.name = p.getPropertyName();
			this.city = p.getCity();
			this.rentAmount = p.getRentAmount();
			this.owner = p.getOwner();
			this.plot = p.getPlot();
		}


		public String getCity() { 
			return this.city;
		}

		public String getOwner() { 
			return this.owner; 
		}

		public Plot getPlot() { 
			return this.plot; 
		}
		public String getPropertyName() { 
			return this.name; 
		}

		public double getRentAmount() { 
			return this.rentAmount; 
		}

		public void setCity(String city) { 
			this.city = city; 
		}

		public void setOwner(String owner) { 
			this.owner = owner;
		}
	public void setPropertyName(String name) { 
			this.name = name; 
		}
		public void setRentAmount(double rent) { 
			this.rentAmount = rent; 
		}
		
		public String toString() {
			String s = "";
			s += "Property Name: " + this.getPropertyName();
			s += "\n" + "Located in " + this.getCity();
			s += "\n" + "Belonging to: " + this.getOwner();
			s += "\n" + "Rent Amount: " + this.getRentAmount();
			s += " ";
			return s;
		}
}
