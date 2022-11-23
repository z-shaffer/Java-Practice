public interface Smelting {
    public void manufacture();
}

class Smelt1 implements Smelting {
    public void manufacture()
    {
        System.out.println("2.5% Cu and 97.5% Zn");
    }
}

class Smelt2 implements Smelting {
    public void manufacture()
    {
        System.out.println("75% Cu and 25% Ni");
    }
}

class Smelt3 implements Smelting {
    public void manufacture()
    {
        System.out.println("91.67% Cu and 8.33% Ni");
    }
}

class Smelt4 implements Smelting {
    public void manufacture()
    {
        System.out.println("88.5% Cu, 6% Zn, 3.5% Mn, 2% Ni");
    }
}

class Smelt5 implements Smelting {
    public void manufacture()
    {
        System.out.println("Unknown specs");
    }
}