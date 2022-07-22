
public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property properties[] = new Property[MAX_PROPERTY];
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int current = -1;

	// Constructors
	ManagementCompany() {
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		String name = "";
		String taxID = "";
		double mgmFeePer = 0.00;
	}

	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
	}

	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.mgmFeePer = mgmFee;
		this.name = name;
		this.taxID = taxID;
		this.plot = new Plot(x, y, width, depth);
	}

	public ManagementCompany(ManagementCompany otherCompany) {
		otherCompany = new ManagementCompany();
	}

	// Methods
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}

	public int addProperty(Property property) {

		int nuevo = current + 1;
		if (nuevo >= this.MAX_PROPERTY) {
			return -1;
		}
		this.properties[nuevo] = new Property(property);
		current = nuevo;
		return nuevo;
	}

	public int addProperty(String name, String city, double rent, String owner) {
		int nuevo = current + 1;
		this.properties[nuevo] = new Property(name, city, rent, owner);
		current = nuevo;
		if (nuevo >= this.MAX_PROPERTY) {
			return -1;
		}
		return nuevo;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int nuevo = current + 1;
		Plot t = new Plot(x, y, width, depth);
		if (nuevo >= this.MAX_PROPERTY) {
			return -1;
		}
		if (this.plot.encompasses(t) == false) {
			return -3;
		}
		if (current >= 0) {
			for (int i = 0; this.properties[i].equals(null); i++) {
				if (this.properties[i] == null) {
					continue;
				}
				if (this.properties[i].getPlot().overlaps(t) == true) {
					return -4;
				}
			}
		}
		this.properties[nuevo] = new Property(name, city, rent, owner, x, y, width, depth);
		current = nuevo;
		return nuevo;
	}

	public double totalRent() {
		double total = 0;
		for (int i = 0; i < this.properties.length; i++) {
			if (this.properties[i] == null) {
				continue;
			}
			Property p = this.properties[i];
			total += p.getRentAmount();
		}
		return this.properties.length > 0 ? total : 0.00;
	}

	public String maxRentProp() {
		double max = 0;
		String s = "";
		for (int i = 0; i < this.properties.length; i++) {
			Property p = this.properties[i];
			if (p == null) {
				continue;
			}
			if (p.getRentAmount() > max) {
				max = p.getRentAmount();
				s = p.toString();
			}
		}
		return (max > 0 ? s : "");

	}

	public Plot getPlot() {
		return plot;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		// Variables
		String s = "";
		s += "List of properties for " + this.getName() + ", TaxID: " + this.taxID;
		for (int i = 0; i < this.properties.length; i++) {
			if (this.properties[i] == null) {
				continue;
			}
			s += "\n" + this.properties[i].toString();
		}
		s += "\ntotal management Fee: " + (this.totalRent() * (this.mgmFeePer * 0.01));
		return s;
	}

}
