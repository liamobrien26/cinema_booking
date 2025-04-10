package com.cinema.booking.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserDTO {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^(\\+44|0)\\d{10}$", message = "Phone number must be valid UK number")
    private Integer phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;


}

