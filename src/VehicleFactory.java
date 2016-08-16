
public class VehicleFactory {
	
	public static Vehicle getVehicle(String vehicleType)
	{
		int randomX = (int)(Math.random() * 100) + 725;
		if(vehicleType == null)
			return null;
		if(vehicleType.equalsIgnoreCase("car")){
			return new Vehicle(randomX, 400, 49, 49, "src/img/car.png", -1);
		}
		if(vehicleType.equalsIgnoreCase("truck")){
			return new Vehicle(randomX, 450, 49, 99, "src/img/truck.png", 1);
		}
		if(vehicleType.equalsIgnoreCase("raceCar")){
			return new Vehicle(randomX, 500, 49, 49, "src/img/car1.png", 1);
		}
		if(vehicleType.equalsIgnoreCase("tractor")){
			return new Vehicle(randomX, 550, 49, 49, "src/img/tractor.png", 1);
			
		}
		return null;
	}
}
