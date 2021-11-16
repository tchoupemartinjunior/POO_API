import java.util.Comparator;

public class ComSecteur implements Comparator<Secteur> {


    public int compare(Secteur s1, Secteur s2) {
        if(s1.getNombreAnimaux()>s2.getNombreAnimaux()){
            return 1;
        }
        else if(s1.getNombreAnimaux()<s2.getNombreAnimaux()){
            return -1;
        }

        return 0;
    }
}
