package demo3;

public class App2 {
	
	public static void main(String[] args) {
		
		Score s1 = new Score("국어", Grade.A);
		Score s2 = new Score("영어", Grade.B);
		Score s3 = new Score("수학", Grade.F);
		
		double avg = (s1.getGrade().getPoint() + s2.getGrade().getPoint() + s3.getGrade().getPoint())/3.;
		System.out.println(avg);
	}
}
