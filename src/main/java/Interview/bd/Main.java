package Interview.bd;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<entry> list = new ArrayList<>();
        for(int i =0;i<n;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            entry entry = new entry(x,y);
            if(list.contains(entry)){
                list.get(list.indexOf(entry));
            }
            else{
                list.add(entry);
            }
        }
        Collections.sort(list, new Comparator<entry>() {
            @Override
            public int compare(entry o1, entry o2) {
                return o1.scores-o2.scores;
            }
        });
        for (int i = 0; i < m; i++) {
            System.out.println(list.get(m).id);
        }


    }
    static class entry{
        int id;
        int scores;
        public entry(int x,int y){
            this.id = x;
            this.scores = y;
        }

        @Override
        public boolean equals(Object obj) {
            entry entry = (entry) obj;
            return id == entry.id;
        }
    }
}