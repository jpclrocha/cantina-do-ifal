package ifal.cantina;

import java.util.Comparator;

public class ComparadorDescricao implements Comparator<Produtos>{

    @Override
    public int compare(Produtos p1, Produtos p2) {
        if(p1.getDescription().compareTo(p2.getDescription()) > 0){
            return 1;
        }
        return -1;
    }
    
}
