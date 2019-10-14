package ObjectOrientedProgramming.Composition.Challenge;
import java.util.Objects;

public class Bed {

    private String material;
    private Mattress mattress;
    private Sheet sheet;
    private Blanket blanket;

    public Bed(String material, Mattress mattress, Sheet sheet, Blanket blanket) {
        this.material = material;
        this.mattress = mattress;
        this.sheet = sheet;
        this.blanket = blanket;
    }

    private void isComfy() {
        if (this.material.equals(mattress.getMaterial())
                && this.material.equals(sheet.getMaterial())
                && this.material.equals(sheet.getMaterial())) {

            System.out.println("Materials on all elements of the bed are all the same, most be comfy!");
        } else {
            System.out.println("Materials on the bed don't match, but i guess it's comfy for you anyways, not for me.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return  Objects.equals(material, bed.material) &&
                Objects.equals(mattress, bed.mattress) &&
                Objects.equals(sheet, bed.sheet) &&
                Objects.equals(blanket, bed.blanket);
    }
}
