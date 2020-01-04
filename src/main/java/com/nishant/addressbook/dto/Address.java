package com.nishant.addressbook.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@JsonFilter("AddressFilter")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    @ApiModelProperty(notes="Address id should be numnric")
    @Digits(integer =5, fraction =0, message = "must have 6 digits")
    private Integer addressId;

    @ApiModelProperty(notes="Contact id should be numnric")
    @Digits(integer =6, fraction =0, message = "must have 6 digits")
    private Integer contactId;

    @ApiModelProperty(notes="Address Line 1 should be greater than 5 chars")
    @Size(min = 5, message = "Address Line 1 should be greater than 5 chars")
    @NotNull(message = "Address Line 1 cannot be null")
    private String addressLine1;

    @ApiModelProperty(notes="Address Line 2 is optional")
    private String addressLine2;

    @ApiModelProperty(notes="City should be greater than 3 chars")
    @Size(min = 3, message = "City should be greater than 3 chars")
    @NotNull(message = "City cannot be null")
    private String city;

    @ApiModelProperty(notes="State should be 2 chars")
    @Size(min = 2, max =2, message = "State should be 2 chars")
    @NotNull(message = "State cannot be null")
    private String state;

    @ApiModelProperty(notes="Country should be 2 chars")
    @Size(min = 2, max =2, message = "Country should be 2 chars")
    @NotNull(message = "Country cannot be null")
    private String country;

    @ApiModelProperty(notes="Postal Code should be 5 chars")
    @Size(min = 5, max =10, message = "Postal Code should be 5 char")
    @NotNull(message = "Postal Code cannot be null")
    private String postalCode;

    @ApiModelProperty(notes="Flag: true of false, default will be true")
    private boolean isMailing;

    @ApiModelProperty(notes="Flag: true of false, default will be false")
    private boolean isShipping;
}
