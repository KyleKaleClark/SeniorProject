
public class Intersects {

	public boolean point_circle(int[] point, int[] circle)
	{
		int a = point[0] - circle[0];
		int b = point[1] - circle[1];
		int c = circle[2];
		
		return ((a*a) + (b*b) <= (c*c));
	}
	
	public boolean point_rect(int[] point, int[] rect)
	{
		int x = point[0];
		int y = point[1];
		
		int left = rect[0];
		int right = rect[0] + rect[2];
		int top = rect[1];
		int bottom = rect[1] + rect[3];
		
		return (left < x && x < right) && (top < y && y < bottom);
	}
	
	public boolean circle_circle(int[] circle1, int[] circle2)
	{
		int a = circle1[0] - circle2[0];
		int b = circle1[1] - circle2[1];
		int c = circle1[2] + circle2[2];
		
		return ((a*a) + (b*b) <= (c*c));
	}
	
	public boolean rect_rect(int[] rect1, int[] rect2)
	{
		int left1 = rect1[0];
		int right1 = rect1[0] + rect1[2];
		int top1 = rect1[1];
		int bottom1 = rect1[1] + rect1[3];
		
		int left2 = rect2[0];
		int right2 = rect2[0] + rect2[2];
		int top2 = rect2[1];
		int bottom2 = rect2[1] + rect2[3];
		
		return !(right1 < left2 || left1 > right2 || bottom1 < top2 ||
				top1 > bottom2);
	}
	
	
	
	
}
