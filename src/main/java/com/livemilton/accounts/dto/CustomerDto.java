package com.livemilton.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer",
        description="Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            name="Name of the customer",example="Livemilton"

    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min=5, max=30,message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            name="Email address of the customer",example="Livemilton@hotmail.com"

    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            name="Mobile Number of the customer",example="3003778759"

    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            name="Account details of the Customer"

    )
    private AccountsDto accountsDto;
}
