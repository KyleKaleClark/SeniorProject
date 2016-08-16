
public class GameLogic {
	Frogger froggy = Frogger.getInstance();
	
	Goal[] goalList = GoalInit();
	Log[] logList = LogInit();
	Vehicle[] truckList = VehicleInit();
	public GameLogic(){
		
	}
	public void checkIntersections()
	{
		
		Intersects intersect = new Intersects();
		int[] froggyRect = {froggy.getXLoc(), froggy.getYLoc(), 49, 49};
		int[] roadRect = {0, 350, 1000, 500};
		
		for (int i = 0; i < truckList.length; i++)
		{
			int[] otherRect = truckList[i].getRect();
			if (intersect.rect_rect(froggyRect, otherRect))
			{
				froggy.killFrogger();
			}
		}
		for (int i = 0; i < goalList.length; i++)
		{
			int[] otherRect = goalList[i].getRect();
			if (intersect.rect_rect(froggyRect, otherRect) && goalList[i].returnActive())
			{
				goalList[i].setActive(false);
				goalList[i].changeImage("src/img/imgU.png");
				froggy.addScore(100);
				froggy.setXLoc(400);
				froggy.setYLoc(600);
				froggy.setLives(froggy.getLives() + 1);
			}
			else if (intersect.rect_rect(froggyRect, otherRect) && !(goalList[i].returnActive()))
			{
				froggy.killFrogger();
			}
		}
		
		
		for (int i = 0; i < truckList.length; i++) {
			  for (int j = i+1; j < truckList.length; j++) {
			    // compare list.get(i) and list.get(j)
				  int[] firstRect = truckList[i].getRect();
				  int[] secondRect = truckList[j].getRect();
				  if (intersect.rect_rect(firstRect, secondRect)){
					  int seperationAmt = (int) (Math.random() * 200) + 150;
					  truckList[j].setXLoc(truckList[j].getXLoc() - seperationAmt);
				  }
			  }
			}
		for (int i = 0; i < logList.length; i++) {
			  for (int j = i+1; j < logList.length; j++) {
			    // compare list.get(i) and list.get(j)
				  int[] fixed1 = logList[i].getRect();
				  int[] fixed = logList[j].getRect();
				  fixed[2] = 149;
				  fixed1[2] = 149;
				  int[] secondRect = logList[j].getRect();
				  if (intersect.rect_rect(fixed1, fixed)){
					  int seperationAmt = (int) (Math.random() * 200) + 150;
					  logList[j].setXLoc(logList[j].getXLoc() - seperationAmt);
					  System.out.println("UMMMM" + (logList[j].getXLoc() - seperationAmt));
					
				  }
			  }
			}
		
		for (int i = 0; i < logList.length; i++)
		{
			int[] otherRect = logList[i].getRect();
			if (intersect.rect_rect(froggyRect, otherRect))
			{
				froggy.setXLoc((froggy.getXLoc()+(1*logList[i].getDir())));
			}
		}
		if (froggy.getXLoc() >= 700){ froggy.killFrogger();}
		if (froggy.getXLoc() <= -25){ froggy.killFrogger();}
		
		boolean onLog = false;
		if(!(intersect.rect_rect(froggyRect, roadRect))){
			for (int i = 0; i < logList.length; i++){
				if (intersect.rect_rect(froggyRect, logList[i].getRect())){
					onLog = true;
					break;
				}
				else{ onLog = false;}
			}
			if (onLog == false){ froggy.killFrogger();}
		}
				
			
		
		
	}

	public void checkWin(){
		int count = 0;
		for (int i = 0; i<goalList.length; i++){
			if (!goalList[i].returnActive()){
				count++;
				System.out.println(count);
			}
		}
		if (count == 7){
			System.out.println("YOU WIN BBY");
		}
	}
	
	public Vehicle[] getTruckList(){return truckList;}
	public Log[] getLogList(){return logList;}
	public Goal[] getGoalList(){return goalList;}
	
	private Vehicle[] VehicleInit(){
		Vehicle truck = VehicleFactory.getVehicle("truck");
		Vehicle truck2 = VehicleFactory.getVehicle("truck");
		Vehicle truck3 = VehicleFactory.getVehicle("truck");
		Vehicle car = VehicleFactory.getVehicle("car");
		Vehicle car2 = VehicleFactory.getVehicle("car");
		Vehicle car3 = VehicleFactory.getVehicle("car");
		Vehicle raceCar = VehicleFactory.getVehicle("raceCar");
		Vehicle raceCar2 = VehicleFactory.getVehicle("raceCar");
		Vehicle raceCar3 = VehicleFactory.getVehicle("raceCar");
		Vehicle tractor = VehicleFactory.getVehicle("tractor");
		Vehicle tractor2 = VehicleFactory.getVehicle("tractor");
		Vehicle tractor3 = VehicleFactory.getVehicle("tractor");
		Vehicle tractor4 = VehicleFactory.getVehicle("tractor");
		Vehicle[] truckList = {truck, truck2,truck3,car3,raceCar3,
				car, car2, raceCar, raceCar2, tractor};
		return truckList;
	}

	private Log[] LogInit(){
		Log log1 = new Log((int)(Math.random() * 600), 300, 1);
		Log log2 = new Log((int)(Math.random() * 600), 250, -1);
		Log log3 = new Log((int)(Math.random() * 600), 200, 1);
		Log log4 = new Log((int)(Math.random() * 600), 150, -1);
		Log log5 = new Log((int)(Math.random() * 600), 100, 1);
		Log log6 = new Log((int)(Math.random() * 600), 50, -1);
		Log log7 = new Log((int)(Math.random() * 600), 300, 1);
		Log log8 = new Log((int)(Math.random() * 600), 250, -1);
		Log log9 = new Log((int)(Math.random() * 600), 200, 1);
		Log log10 = new Log((int)(Math.random() * 600), 150, -1);
		Log log11 = new Log((int)(Math.random() * 600), 100, 1);
		Log log12 = new Log((int)(Math.random() * 600), 50, -1);
		Log[] logList = {log1, log2, log3, log4, log5, log6, log7, log8, log9, log10,
				log11, log12};
		return logList;
	}

	private Goal[] GoalInit(){
		Goal goal1 = new Goal(30,0);
		Goal goal2 = new Goal(130,0);
		Goal goal3 = new Goal(230, 0);
		Goal goal4= new Goal(330, 0);
		Goal goal5 = new Goal(430, 0);
		Goal goal6 = new Goal(530, 0);
		Goal goal7 = new Goal(630, 0);
		
		Goal[] goalList = {goal1, goal2, goal3, goal4, goal5, goal6, goal7};
		return goalList;
	}

}
