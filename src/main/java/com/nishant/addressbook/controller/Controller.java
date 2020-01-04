package com.nishant.addressbook.controller;

import com.nishant.addressbook.dto.Address;
import com.nishant.addressbook.service.AddressService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private Environment environment;

    @Autowired
    AddressService addressService;

    @GetMapping("contacts/{contactId}/addresses")
    @ApiOperation(value="Find addresses by contact ID", notes = "Find addresses by contact ID")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =404, message = "Not Found"),
            @ApiResponse(code =500, message = "Internal Server Error")})
    public List<Address> findAddressByContactId(@PathVariable Integer contactId){

        LOGGER.info("Requested data from server: {}", environment.getProperty("local.server.port"));
        return addressService.findAddressesByContactId(contactId);
    }

    @GetMapping("addresses/{addressId}")
    @ApiOperation(value="Find addresses by address ID", notes = "Find addresses by address ID")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Success"),
            @ApiResponse(code =404, message = "Not Found"),
            @ApiResponse(code =500, message = "Internal Server Error")})
    public Address findAddressByAddressId(@PathVariable Integer addressId){

        LOGGER.info("Requested data from server: {}", environment.getProperty("local.server.port"));
        return addressService.findContactById(addressId);
    }

    @PostMapping("addresses")
    @ApiResponses(value = {@ApiResponse(code =201, message = "Created"),
            @ApiResponse(code =400, message = "Bad Request-Contact Already exists"),
            @ApiResponse(code =500, message = "Internal Server Error")})
    public Address addAddress(@Valid @RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("contacts/{contactId}/addresses")
    @ApiOperation(value="Update an address on contact", notes = "Update an address on contact")
    @ApiResponses(value = {@ApiResponse(code =201, message = "Updated"),
            @ApiResponse(code =400, message = "Bad Request-Contact does not exists"),
            @ApiResponse(code =500, message = "Internal Server Error")})
    public Address updateAddress(@PathVariable Integer contactId, @Valid @RequestBody Address address){
        return addressService.updateAddress(contactId, address);
    }

    @DeleteMapping("contacts/{contactId}/addresses")
    @ApiOperation(value="Delete an address on contact", notes = "Delete an address on contact")
    @ApiResponses(value = {@ApiResponse(code =200, message = "Deleted"),
            @ApiResponse(code =400, message = "Bad Request-Contact does not exists"),
            @ApiResponse(code =500, message = "Internal Server Error")})
    public void deleteAddress(Integer contactId){
        addressService.deleteAddress(contactId);
    }
}
