import java.util.ArrayList;

public class Skills {
	
	private double degreeGrade;
	private int educationLevel ;
	private ArrayList<String> programmingLanguages ;
	private int workExperience ;
	private ArrayList<String> foreignLanguages ;
	private ArrayList<String> SoftwareKnowledge ;
	
	
	public Skills(double degreeGrade, int educationLevel, ArrayList<String> programmingLanguages, int workExperience,
			ArrayList<String> foreignLanguages, ArrayList<String> softwareKnowledge) {
		
		this.degreeGrade = degreeGrade;
		this.educationLevel = educationLevel;
		this.programmingLanguages = programmingLanguages;
		this.workExperience = workExperience;
		this.foreignLanguages = foreignLanguages;
		SoftwareKnowledge = softwareKnowledge;
	}

	public double getDegreeGrade() {
		return degreeGrade;
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
