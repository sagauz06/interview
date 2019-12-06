package div.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
@Entity
public class YoyoCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	// @Min(1000)
	@Min(value = 1000, message = "金額不小於1000")
	private int money;
}
