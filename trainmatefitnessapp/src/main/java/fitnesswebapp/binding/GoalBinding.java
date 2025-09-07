package fitnesswebapp.binding;

import lombok.Data;

@Data
public class GoalBinding {
	
	private String title;
	private String description;
	private String targetValue;
	private String status;
}