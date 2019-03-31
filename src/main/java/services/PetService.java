package services;

import entities.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PetService {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petsAndPetOwners");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();
    private EntityTransaction entityTransaction = entityManager.getTransaction();

    public Pet createPet(String name, String type, Integer age, String sex){
        Pet pet = new Pet();
        pet.setName(name);
        pet.setType(type);
        pet.setAge(age);
        pet.setSex(sex);

        entityTransaction.begin();
        entityManager.persist(pet);
        entityTransaction.commit();

        return pet;
    }

    public Pet findPet(Integer id) {
        return entityManager.find(Pet.class, id);
    }

    public Pet updatePet(Pet pet){
        entityTransaction.begin();
        entityManager.remove(entityManager.find(Pet.class, pet.getId()));
        entityManager.persist(pet);
        entityTransaction.commit();
        return pet;
    }

    public Pet updateAge(Integer id, Integer age){
        Pet pet = entityManager.find(Pet.class, id);
        if(pet != null){
            entityTransaction.begin();
            pet.setAge(age);
            entityTransaction.commit();
        }
        return pet;
    }

    public void deletePet(Integer id){
        Pet pet = entityManager.find(Pet.class, id);
        if(pet != null){
            entityTransaction.begin();
            entityManager.remove(pet);
            entityTransaction.commit();
        }
    }

    public void deletePet(Pet pet){
        Pet petToBeDeleted = entityManager.merge(pet);
        entityTransaction.begin();
        entityManager.remove(petToBeDeleted);
        entityTransaction.commit();
    }
}
