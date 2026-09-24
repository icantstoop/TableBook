package com.example.TableBook.controller;

import com.example.TableBook.dto.RestaurantTableRequest;
import com.example.TableBook.dto.RestaurantTableResponse;
import com.example.TableBook.service.RestaurantTableService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantTableController {
    private final RestaurantTableService restaurantTableService;

    @GetMapping(value = "/api/v1/tables")
    public ResponseEntity<List<RestaurantTableResponse>> findAll(){
        return ResponseEntity.ok(restaurantTableService.findAll());
    }

    @GetMapping(value = "/api/v1/tables/{id}")
    public ResponseEntity<RestaurantTableResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(restaurantTableService.findById(id));
    }

    @PostMapping(value = "/api/v1/tables")
    public ResponseEntity<RestaurantTableResponse> create(@Valid @RequestBody RestaurantTableRequest request){
        RestaurantTableResponse tables = restaurantTableService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(tables);

    }

    @PutMapping(value = "/api/v1/tables/{id}")
    public ResponseEntity<RestaurantTableResponse> update(@PathVariable Long id, @Valid @RequestBody RestaurantTableRequest request){
        return ResponseEntity.ok(restaurantTableService.update(id, request));
    }

    @DeleteMapping(value = "/api/v1/tables/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id){
        restaurantTableService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
