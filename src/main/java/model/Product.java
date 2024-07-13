package model;


import jakarta.validation.constraints.*;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Positive
    private int id ;

    @NotBlank(message = "Name is invalid")
    private String name ;


    @Positive
    private double price ;

    @PositiveOrZero(message = "Quantity must be zero or a positive number")
    private double Quantity;


}
