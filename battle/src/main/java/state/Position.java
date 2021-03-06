package state;

public class Position {
	private double x;
	private double y;
	private double z;

	public Position(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getDistance(Position p){
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		double result = Math.sqrt(dx * dx + dy * dy);
		double dz = this.z - p.z;
		result = Math.sqrt(result * result + dz * dz);
		return result;
	}
	
}
