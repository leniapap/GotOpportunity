import java.util.ArrayList;

public class Skills {
	
	private double degreeGrade;
	private int educationLevel ;
	private ArrayList<String> programmingLanguages ;
	private int workExperience ;
	private ArrayList<String> foreignLanguages ;
	private ArrayList<String> SoftwareKnowledge ;
	
	public double getDegreeGrade() {
		return degreeGrade;
	}
	public void setDegreeGrade(double degreeGrade) {
		this.degreeGrade = degreeGrade;
	}
	public int getEducationLevel() {
		return educationLevel;
	}
	public ArrayList<String> getProgrammingLanguages() {
		return programmingLanguages;
	}
	public int getWorkExperience() {
		return workExperience;
	}
	public ArrayList<String> getForeignLanguages() {
		return foreignLanguages;
	}
	public ArrayList<String> getSoftwareKnowledge() {
		return SoftwareKnowledge;
	}
	
}
