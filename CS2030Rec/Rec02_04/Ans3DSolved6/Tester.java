package CS2030Rec.Rec02_04.Ans3DSolved6;

public class Tester {

    public static void main(String[] args) {
        Material material = new Material(10);
        Cuboid cuboid = new Cuboid(10, 1, 10);

        SolidCuboid solidcuboidOne = new SolidCuboid(cuboid, material);
        SolidCuboid solidcuboidTwo = new SolidCuboid(10, 1, 10, 10);

        // Solid3D is an abstract class while Shape3D is an interface.
        // Therefore we cannot create instances of Shape3D and Solid3D individually.

        // Material: getDensity
        System.out.println("Material getDensity: " + material.getDensity());

        // Cuboid implements Shape3D: getVolume
        System.out.println("Cuboid (implements Shape3D) getVolume: " + cuboid.getVolume());

        // SolidCuboid extends Solid3D: getVolume, getDensity, getMass
        System.out.println("SolidCuboidOne (extends Solid3D): getVolume: " + solidcuboidOne.getVolume());
        System.out.println("SolidCuboidOne (extends Solid3D): getDensity: " + solidcuboidOne.getDensity());
        System.out.println("SolidCuboidOne (extends Solid3D): getMass: " + solidcuboidOne.getMass());

        // Test if Two gives the Same Results as One
        System.out.println("SolidCuboidTwo (extends Solid3D): getVolume: " + solidcuboidTwo.getVolume());
        System.out.println("SolidCuboidTwo (extends Solid3D): getDensity: " + solidcuboidTwo.getDensity());
        System.out.println("SolidCuboidTwo (extends Solid3D): getMass: " + solidcuboidTwo.getMass());

    }

}
