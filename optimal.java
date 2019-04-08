    public static void Optimal_alg(int[]a, int [] b){   //a is the string , b is frames
        System.out.println("we in Optimal ALgorithm");
        ArrayList<Integer> refString = conver_arr_arrlst(a);
        ArrayList<Integer> frames = conver_arr_arrlst(b);
        int pageFault = 0;
        int hit = 0;
        int miss = 0;
        for (int i = 0; i < a.length; i++) {
            if(frames.contains(refString.get(i))){
                hit++;
                continue;
            }
//            else if (!frames.contains(refString.get(i))){
//                miss++;
//                continue;
//            }
            if (i < frames.size()){
                if (!frames.contains(refString.get(i))){
                    frames.set(i, refString.get(i));
                    pageFault++;
                }
            }
            else{
                int replaceIndex = findNextRef(a, a[i], i + 1);
                frames.set(replaceIndex, refString.get(i));
                pageFault++;
            }

        }
        System.out.println("Hits: " + hit);
        System.out.println("Misses: " + (refString.size() - hit));
        System.out.println("Page Faults: " + pageFault);

    }
    static boolean searchOptimal(int [] array, int num){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return true;
        }
        return false;
    }
    static int findNextRef(int [] array, int num, int nextIndex){
        int index = -1, farthest = nextIndex;
        ArrayList<Integer> refString = conver_arr_arrlst(array);
        for (int i = 0; i < refString.size(); i++) {
            int j;
            for (j = nextIndex; j < array.length; j++) {
                if (j > farthest){
                    farthest = j;
                    index = i;
                }
                break;
            }
            if (j == array.length)
                return i;
        }
        return (index == -1 ? 0: index);
    }
