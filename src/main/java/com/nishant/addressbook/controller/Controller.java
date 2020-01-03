package com.nishant.addressbook.controller;

import com.nishant.addressbook.dto.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class Controller {

    private Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private Environment environment;

    @GetMapping
    public List<Address> findAllAddresses(){

        LOGGER.info("Requested data from server: {}", environment.getProperty("local.server.port"));

        return new ArrayList<Address>() {
            {
                add(Address.builder().addressId(100001).addressLine1("901 Players Ct")
                        .addressLine2("901").city("Nashville").state("TN")
                        .country("US").postalCode("53714")
                        .build());
                add(Address.builder().addressId(100002).addressLine1("902 Players Ct")
                        .addressLine2("902").city("Nashville").state("TN")
                        .country("US").postalCode("53714")
                        .build());
                add(Address.builder().addressId(100003).addressLine1("903 Players Ct")
                        .addressLine2("903").city("Nashville").state("TN")
                        .country("US").postalCode("53714")
                        .build());
            }
        };
    }

    @GetMapping("id/{addressId}")
    public Address findAddress(){
        return Address.builder()
                .addressId(100001)
                .addressLine1("902 Players Ct")
                .addressLine2("902")
                .city("Nashville")
                .state("TN")
                .country("US")
                .postalCode("53714")
                .build();
    }

    @PostMapping
    public List<Address> addAddress(@Valid @RequestBody Address address){
        return null;
    }

    @PutMapping("id/{addressId}")
    public Address updateAddress(@PathVariable Integer addressId, @Valid @RequestBody Address address){
        return null;
    }

    @DeleteMapping("id/{addressId}")
    public void deleteAddress(Integer addressId){
    }


}
