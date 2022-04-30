package ifal.cantina;

import java.util.Comparator;

public class ComparadorQtd implements Comparator<Produtos>{

    @Override
    public int compare(Produtos p1, Produtos p2) {
        if(Integer.compare(p1.getAvailableAmount(), p2.getAvailableAmount()) > 0){
            return 1;
        }
        return -1;
    }
    
}
