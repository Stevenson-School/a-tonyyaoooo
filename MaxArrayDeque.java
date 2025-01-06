import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    public Comparator<T> comparator;

    public MaxArrayDeque(){
    }

    public MaxArrayDeque(Comparator<T> c){
        comparator = c;
    }

    public T max(){
        int  bigIndex = 0;
        for (int i=0; i<size(); i++){
            if (this.comparator.compare(this.get(i), this.get(bigIndex))>0){
                bigIndex=i;
            }
        }
        return this.get(bigIndex);
    }

    public T max(Comparator<T> c){
        int  bigIndex = 0;
        for (int i=0; i<size(); i++){
            if (c.compare(this.get(i), this.get(bigIndex))>0){
                bigIndex=i;
            }
        }
        return this.get(bigIndex);
    }

}
