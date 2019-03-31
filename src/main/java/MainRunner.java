import entities.Pet;
import services.PetService;

public class MainRunner {

    public static void main(String[] args) {
        Pet pet = new Pet("Gizmo", "dog", 15, "male");
        PetService petService = new PetService();
        petService.createPet(pet.getName(), pet.getType(), pet.getAge(), pet.getSex());


        Pet findPet = petService.findPet(1);
        System.out.println(findPet.getName());
    }

}
