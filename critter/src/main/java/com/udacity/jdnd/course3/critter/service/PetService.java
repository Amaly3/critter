package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.repository.CustomerRepository;
import com.udacity.jdnd.course3.critter.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet CreatePet(Pet pet) {
        return petRepository.save(pet);
    }


    public Pet getPet(Long petId) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet pet = optionalPet.get();
            return pet;
        } else {
            throw new PetNotFoundException();
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        return pets;
    }

    public List<Pet> findPetsByOwner(Long ownerId){
       return petRepository.findPetsByOwner(ownerId);
    }

}