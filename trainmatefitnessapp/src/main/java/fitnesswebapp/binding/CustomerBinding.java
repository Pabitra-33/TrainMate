package fitnesswebapp.binding;

import lombok.Data;

@Data
public class CustomerBinding {

	private String username;
	private String password;
	private Integer age;
	private String email;
}