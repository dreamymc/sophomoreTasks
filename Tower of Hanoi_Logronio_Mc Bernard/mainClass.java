public class mainClass {
    public static void main(String[] ukiyo) {
        towerOfHanoi tower = new towerOfHanoi();
        // initializing the towers
        tower.Pole1.push(tower.largeDisk);
        tower.Pole1.push(tower.mediumDisk);
        tower.Pole1.push(tower.smallDisk);
        tower.print();
        // user defined section
        tower.run();
    }
}
